select total.request_at as day, round(IFNULL(cancel.tot,0)/total.tot, 2) as 'Cancellation Rate'
from
(
    select request_at, count(*) as tot
    from Trips t, Users client, Users driver
    where t.client_id = client.users_id
    and t.driver_id = driver.users_id
    and client.banned = 'No' and driver.banned = 'No'
    and t.status like 'cancelled%'
    and t.request_at >= DATE('2013-10-01')
    and t.request_at <= DATE('2013-10-03')
    group by request_at
) cancel
right join
(
    select request_at, count(*) as tot
    from Trips t, Users client, Users driver
    where t.client_id = client.users_id
    and t.driver_id = driver.users_id
    and client.banned = 'No' and driver.banned = 'No'
    and t.request_at >= DATE('2013-10-01')
    and t.request_at <= DATE('2013-10-03')
    group by request_at
) total
on cancel.request_at = total.request_at;
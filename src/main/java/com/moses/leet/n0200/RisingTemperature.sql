# Write your MySQL query statement below
select w1.id
from Weather w1, Weather w2
where w1.RecordDate = DATE_ADD(w2.RecordDate, 1)
and w1.temperature > w2.temperature;
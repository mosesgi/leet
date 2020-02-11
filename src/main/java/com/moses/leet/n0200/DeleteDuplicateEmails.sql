delete p from Person p, Person p1
where p.Email = p1.Email
and p.id > p1.id;
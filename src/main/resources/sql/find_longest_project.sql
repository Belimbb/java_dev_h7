select 
	p.id, 
	max(extract(year from age(p.finish_date::date, p.start_date::date)) * 12 + extract(month from age(p.finish_date::date, p.start_date::date))) 
from 
	project p 
group by 
	p.id
having 
    max(extract(year from age(p.finish_date::date, p.start_date::date)) * 12 + extract(month from age(p.finish_date::date, p.start_date::date)))
    IN (
        SELECT max(EXTRACT(YEAR FROM AGE(p2.finish_date::date, p2.start_date::date)) * 12 + EXTRACT(MONTH FROM AGE(p2.finish_date::date, p2.start_date::date)))
        FROM project p2
    );
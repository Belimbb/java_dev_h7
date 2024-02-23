select 
	pw.project_id,
	sum((extract(year from age(p.finish_date::date, p.start_date::date)) * 12 + extract(month from age(p.finish_date::date, p.start_date::date)))*w.salary) as price 
from 
	project_worker pw 
inner join 
	project p on pw.project_id = p.id
inner join 
	worker w on pw.worker_id = w.id
group by 
	pw.project_id
order by
	price desc;

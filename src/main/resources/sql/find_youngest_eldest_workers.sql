select 'OLDEST' as Type, w."name" , w.birthday from worker w where birthday in (select min(w2.birthday) from worker w2)
union
select 'YOUNGEST' as Type, w."name" , w.birthday from worker w where birthday in (select max(w2.birthday) from worker w2);

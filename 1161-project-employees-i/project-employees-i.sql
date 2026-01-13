# Write your MySQL query statement below

select project_id , Round(sum(e.experience_years)/count(p.project_id ),2) as average_years 
from employee e
join project p
on e.employee_id = p.employee_id
group by project_id
order by project_id




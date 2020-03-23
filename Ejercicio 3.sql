-- Ejercicio 3
-- 3. Mostrar los email de los empleados sin asistencia

SELECT name, email FROM manufacturing.employee 
left join attendance on employee.username = attendance.empusername 
where attendance.value is null;
-- Ejercicio 1
-- 1. Mostrar el nombre del cliente con ordenes en status Done

SELECT distinct name FROM manufacturing.clients
inner join orders on clients.username = orders.clientusername 
&& orders.status = 'Done';
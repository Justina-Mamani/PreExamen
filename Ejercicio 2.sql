-- Ejercicio 2
-- 2.Mostrar el costo y tipo de transporte de las ordenes de cliente con nombre 'x'

SELECT distinct name, cost ,modeoftransport FROM manufacturing.clients
inner join delivery on clients.username=delivery.clntusername
inner join product on delivery.item=product.producttype
where clients.name = 'New Client 1';
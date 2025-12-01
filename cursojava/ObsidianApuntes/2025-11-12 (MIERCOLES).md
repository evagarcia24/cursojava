API (Application Program Interface) es un conjunto de reglas, clases, interfaces, buenas practicas...que nos permite realizar una serie de acciones.

API JDBC está orientado unicamente a las BBDD y necesita un **driver** (cada BBDD tiene su propio driver).


### **TRANSACCIONES**
Solo tienen Commit y Rollback:

Commit y Rollback → controlan la atomicidad (o se ejecuta todo o no se ejecuta nada).
El commit debe ser la ultima linea del commit.
Un rollback esta siempre dentro de un catch.


**INSERT**
![[Pasted image 20251112165605.png]]

### **FICHEROS**
Clase File


### **DATE**

## **Archivos de Servicio**
Son funcionalidades que nos sirven de manera transversal para lo que tengamos en nuestro proyecto.

🛠️ ¿Qué son los Archivos de Servicio?

Son clases que contienen **lógica auxiliar** o **funciones comunes** que pueden ser utilizadas por múltiples componentes del proyecto.

📦 Ejemplos típicos de servicios

![[Pasted image 20251112203905.png]]
✅ Ventajas

- **Reutilización**: Evitas duplicar código en múltiples clases.
- **Mantenimiento**: Si algo cambia, lo actualizas en un solo lugar.
- **Claridad**: Separas la lógica de negocio de la lógica técnica.

**(En un proyecto no se utilizan nunca rutas absolutas)**


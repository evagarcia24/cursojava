## **NORMALIZACION**
1FN: Primera Forma de Normalizacion: En una tabla no puede haber multivalorados
📘 **Primera Forma Normal (1FN)**

La **1FN** establece que **una tabla está en Primera Forma Normal si cumple con las siguientes condiciones**:

- ✅ **Cada celda contiene un solo valor atómico** (no listas, conjuntos ni estructuras).
- ✅ **No hay columnas multivaluadas** (es decir, no se permiten múltiples valores en una sola columna).
- ✅ **Cada registro es único** (aunque esto se refuerza más en formas posteriores).

![[Pasted image 20251029163248.png]]
![[Pasted image 20251029163606.png]]

2FN : SEGUNDA FORMA NORMAL
Una tabla está en **Segunda Forma Normal** si:

- ✅ **Está en Primera Forma Normal (1FN)**.
- ✅ **Todos los atributos no clave dependen completamente de la clave primaria**.

- Es decir, **no hay dependencias parciales**: ningún campo debe depender solo de una parte de la clave compuesta.

3FN: Tercera Forma Normal. Las BBDD Relacionales deben ser siempre en 3FN.
No hay dependencias transitivas, **SE NECESITA UNA TABLA INTERMEDIA**

Si una bbdd relacional no esta en 3FN está mal hecha
#### **AOP : Programación Orientada a Aspectos**.
### 💡 ¿Qué es la Programación Orientada a Aspectos (AOP)?

La **Programación Orientada a Aspectos** es un paradigma que **complementa** la Programación Orientada a Objetos (OOP).  
Su objetivo principal es **separar las preocupaciones TRANSEVERSALES** del código, es decir, aquellas partes que afectan a muchas clases o módulos, como:

- Registro de logs
- Manejo de excepciones
- Seguridad / autenticación
- Transacciones
- Monitoreo de rendimiento
---
### 📚 En resumen

| Concepto            | Significado                                                     |
| ------------------- | --------------------------------------------------------------- |
| **AOP**             | Aspect Oriented Programming (Programación Orientada a Aspectos) |
| **Objetivo**        | Separar y modularizar las “preocupaciones transversales”        |
| **Ejemplos de uso** | Logging, seguridad, transacciones, monitoreo                    |

---
**SPRING AOP** (VER)

---
## **EXCEPCIONES**

🔍 ¿Qué son?

- Las **excepciones** son errores que ocurren **en tiempo de ejecución**. JAVA nos avisa de que algo no está bien.
- Todas las excepciones son **objetos** que heredan de la clase `Throwable`.

⚠️ Tipos de errores

- **Error**: Problemas graves ajenos al programador (ej. `OutOfMemoryError`, `StackOverflowError`).  
    👉 _No se recomienda capturarlos con `try-catch`_.
- **Exception**: Errores que el programador puede prever y manejar.  
    👉 _Sí se deben controlar adecuadamente_.



🔁 Flujo de ejecución con excepciones

- Si ocurre una excepción:

- Se **interrumpe** el flujo normal.
- Se **salta** el resto del bloque `try`.
- Se ejecuta el bloque `catch` correspondiente (si lo hay).
- Luego se ejecuta el bloque `finally` (si existe), **siempre**, haya o no excepción.

```java
try {
   // Código que puede lanzar una excepción
} catch (TipoDeExcepcion e) {
   // Código para manejar la excepción
} finally {
   // Código que siempre se ejecuta (ej. cerrar archivos)
}
```
🔁 Flujo de ejecución con excepciones

- Si ocurre una excepción:

- Se **interrumpe** el flujo normal.
- Se **salta** el resto del bloque `try`.
- Se ejecuta el bloque `catch` correspondiente (si lo hay).
- Luego se ejecuta el bloque `finally` (si existe), **siempre**, haya o no excepción.

🧠 Buenas prácticas
• 	No capturar , ya que suelen indicar fallos graves del sistema.
• 	Usar  para liberar recursos (conexiones, ficheros, etc.).
• 	Capturar solo las excepciones que se pueden manejar de forma útil.

✅ Checked vs ❌ Unchecked
Las excepciones se  dividen en checked y unchecked:
	Las unchecked no estamos obligados a controlarlas (rojo en el dibujo)
	Las checked estamos obligados a controlarlas (try catch) (verde en el dibujo).

Estas son las excepciones mas importantes (pero existen más):

![[Pasted image 20251105181640.png]]

Todo lo que hay debajo de una Excepcion no se ejecuta, pasa de la excepcion al catch (si lo hubiera) y lo que hay entre la excepcion y el catch no se ejecuta. Despues continua el codigo que hay debajo del catch (si lo hubiese).

El finally se ejecuta siempre haya habido excepcion o no. Van a ser la ultima linea del try. Es util para cerrar conexiones o cerrar ficheros


Un catch esta necesariamente asociado a un try. Pero un finally no tienen que tener obligatoriamente se ejecuta siempre aunque haya una excepcion sin capturar.

🔁 Relación entre `try`, `catch` y `finally` en Java

🧩 `try` y `catch`
- Un bloque `**catch**` **siempre** debe estar asociado a un bloque `**try**`.
- No puede existir un `catch` sin un `try`.
- Puedes tener múltiples `catch` para manejar diferentes tipos de excepciones.

🧹 `finally`
- El bloque `**finally**` **no necesita** obligatoriamente un `catch`, pero **sí requiere** un `try`.
- Se ejecuta **siempre**, independientemente de si:

	- Se lanzó una excepción.
	- La excepción fue capturada o no.
	- El bloque `try` terminó normalmente.

🧠 ¿Para qué sirve `finally`?

* Ideal para liberar recursos: cerrar archivos, conexiones a base de datos, sockets, etc.
- Garantiza que ciertas acciones se ejecuten sin importar lo que ocurra en el `try`.
---
En try catch, el catch no es obligatorio si hay un finally, pero si no hay finally el catch si es obligatorio
En un catch se pueden meter 2 excepciones:
```java
try {
   // Código que puede lanzar IOException o SQLException
   leerArchivo(); // puede lanzar IOException
   conectarBaseDeDatos(); // puede lanzar SQLException
} catch (IOException | SQLException e) {
   System.out.println("Ocurrió un error: " + e.getMessage());
}
```

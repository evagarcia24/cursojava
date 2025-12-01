Genérico: es el tipo de dato que se guarda. Los genéricos permiten especificar el tipo de dato que se va a manejar en una colección (por ejemplo, `List` o `Map`).
En las colecciones (List y Set) solo hay un tipo de dato.
En los mapas hay 2 tipos de datos: el que tiene la clave y el que tiene el valor. (Puede haber un mapa de mapas).

Lo 1º es inicializar la lista, set o mapa, ya que si no está creado no se puede añadir nada dentro. Se define la variable y después se tiene que iniciar.

```java
// Definir la variable (declaración)
private List<Alimentos> stockAlimentos;
// Inicializar la lista (creación)
List<Alimentos> alimentos = new ArrayList<>();
// Si queremos hacer lo anterior en una linea:
private List<Alimentos> stockAlimentos = new ArrayList<>();
```

Método **.keySet()** : Devuelve un Set con todas las claves del mapa.
Método **.values()** : devuelve los valores
Método **.entrySet()** : Si quieres recorrer un mapa completo (clave y valor). Ejemplo:
```java
Set<Entry<String, Persona>> entries = personas.entrySet();

for (Entry<String, Persona> entry : entries) {
	System.out.println(entry.getKey() + " " + entry.getValue().getNombre());
}
```

De una Lista se pueden generar sublistas (ejemplo: alumnos.subList(0, n)) → Va del indice 0 al n (sin incluirlo)

## **Interface ResultSet**
El objeto _ResultSet es una herramienta clave en JDBC_ para trabajar con los resultados de las consultas SQL


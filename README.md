# Laboratorio 5: TALLER DE MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER

Una pequeña aplicación web que emplea el micro-framework de Spark java (http://sparkjava.com/). Esta aplicación genera un contenedor para Docker, lo despliega y configura en la máquina local. Posteriormente, se establece un repositorio en DockerHub y se carga la imagen en dicho repositorio.

### PREREQUISITOS

* [Java (desde la 15 para delante)](https://www.oracle.com/co/java/technologies/downloads/) 
* [Maven](https://maven.apache.org/download.cgi) 
* [Git](https://git-scm.com/downloads) 

### REQUISITOS

1. Contar con IDE para la ejecución del proyecto o línea de comandos.
2. Contar con los prerequisitos.
3. Al tenerlos, ejecutar el siguiente comando en la maquina

```bash
git clone https://github.com/FDanielMC/AREP_LAB-5.git
```

### Arquitectura

1. FrontEnd:
   - Implementado con HTML y Javascript.
   - Proporciona una interfaz gráfica para interactuar con la aplicación.
   - Permite a los usuarios ingresar valores y enviar peticiones mediante formularios.
   - Muestra los resultados obtenidos de las operaciones realizadas por el backend.

2. Backend:
   - Desarrollado con Spark Java.
   - Define dos endpoints:
       - /calculadora: Muestra la interfaz gráfica inicial.
       - /ccalcular: Recibe las peticiones del cliente, procesa los datos y devuelve el resultado.
       - Maneja operaciones como:
         - Cálculo de seno y coseno.
         - Verificar si una cadena es un palíndromo.
         - Calcular la magnitud de un vector.

3. Docker:
   - Se utiliza para empaquetar la aplicación en un contenedor estandarizado.
   - El Dockerfile especifica las instrucciones para construir la imagen del contenedor, incluyendo las dependencias y la configuración de la aplicación.              

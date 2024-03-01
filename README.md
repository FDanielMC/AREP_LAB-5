# Laboratorio 5: TALLER DE MODULARIZACIÓN CON VIRTUALIZACIÓN E INTRODUCCIÓN A DOCKER

Una pequeña aplicación web que emplea el micro-framework de Spark java (http://sparkjava.com/). Esta aplicación genera un contenedor para Docker, lo despliega y configura en la máquina local. Posteriormente, se establece un repositorio en DockerHub y se carga la imagen en dicho repositorio.

### PREREQUISITOS

* [Java (desde la 15 para delante)](https://www.oracle.com/co/java/technologies/downloads/) 
* [Maven](https://maven.apache.org/download.cgi) 
* [Git](https://git-scm.com/downloads)
* [Docker Desktop](https://www.docker.com/products/docker-desktop/)

### REQUISITOS

1. Contar con IDE para la ejecución del proyecto o línea de comandos.
2. Contar con los prerequisitos.
3. Tener Docker Desktop
4. Al tenerlos, ejecutar el siguiente comando en la maquina

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
       - /calcular: Recibe las peticiones del cliente, procesa los datos y devuelve el resultado.
       - Maneja operaciones como:
         - Cálculo de seno y coseno.
         - Verificar si una cadena es un palíndromo.
         - Calcular la magnitud de un vector.

3. Docker:
   - Se utiliza para empaquetar la aplicación en un contenedor estandarizado.
   - El Dockerfile especifica las instrucciones para construir la imagen del contenedor, incluyendo las dependencias y la configuración de la aplicación.
  
## Ejecución desde la imágen del Repositorio

1. Instale Docker Desktop.
2. Revise que no tenga imágenes docker.
   
   ```
   docker images
   ```
   
![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/f3f51a72-ecec-41cc-b6a1-7634e4021f78)

3. Revise también en Docker Desktop

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/39928bf1-24ff-4ce1-b2ff-94cf6d6e7557)

4. Descargar la imágen desde el repositorio.

    ```
    docker pull fdanielmc/arep_lab-5:latest
    ```

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/2117dd65-e9c0-4689-b722-d72354b32ae1)

5. Verifica que la imagen se haya creado correctamente ejecutando el siguiente comando:
    ```
    docker images
    ```

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/86da5032-2166-4c68-a194-ce2d43ff007e)

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/12454af9-633c-4e94-9842-864f75c2d1dc)

6. Cree un nuevo contenedor a partir de la imagen que está en Docker Hub:
   
    ```
    docker run -d -p 35000:46000 --name areplab5 fdanielmc/arep_lab-5
    ```

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/04de556a-ec15-4b99-a521-9e2f41330d26)

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/cdfc0796-2ef2-4abe-9e41-a1630871e39c)


7. Asegúrese que el contenedor está corriendo:
   
    ```
    docker ps
    ```

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/8c2a9631-4cf2-4c6f-a80d-d4666dc9f7a6)

8. Abre un navegador web y accede a la aplicación en http://localhost:35000/calculadora.

## Generar la Imágen del Proyecto

1. Asegúrate de tener Docker Desktop.
2. Clone el repositorio:
   
    ```
    git clone https://github.com/FDanielMC/AREP_LAB-5.git
    ```
    
4. Navega a la carpeta del proyecto:
   
    ```
    cd AREP_LAB-5
    ```

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/3a039432-eb9b-4404-ad8a-94940a145e37)
    
6. Construye el proyecto usando Maven:
   
    ```
    mvn clean install 
    ```
    
8. Usando la herramienta de línea de comandos de Docker construye la imagen (Reemplace <nombre> con el nombre que desea darle a la imagen):
   
    ```
    docker build --tag <nombre> .
    ```

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/49766fdc-6bed-4e70-87b3-4d2b648a11c4)

10. Verifica que la imagen se haya creado correctamente ejecutando el siguiente comando:
    
    ```
    docker images
    ```

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/573e0814-1c35-43b8-b850-0cc7fa88cae6)


![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/e2eb1075-312b-45bb-b488-d4c07c258ca5)


12. Ya si se desea crear un contenedor con la imágen reemplace <nombre-contenedor> y <nombre> con el nombre que desea darle al contenedor y el nombre de la imágen que  dió anteriormente:
    
    ```
    docker run -d -p 35001:46000 --name <nombre-contenedor> <nombre>
    ```

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/f5c66245-fec0-42be-8f79-7d628ba77b6d)

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/24bab0f5-3a5d-48fc-80b5-4ac194d8d3d0)

14. Asegúrese que el contenedor está corriendo:
    
    ```
    docker ps
    ```

![image](https://github.com/FDanielMC/AREP_LAB-5/assets/123689924/f3d2a132-1943-4c8c-9747-d6d370f28e02)

11. Abre un navegador web y accede a la aplicación en http://localhost:35001/calculadora.


## EJECUTAR PRUEBAS

Para ejecutar las pruebas ingrese el siguiente comando en la línea de comandos:
```
mvn test
```

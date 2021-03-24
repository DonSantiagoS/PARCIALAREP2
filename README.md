# PARCIAL CORTE 1

Aplicacion para consultar el clima de la ciudad que desee segun el reporte de la API gratuita de https://openweathermap.org/ de **Current Weather Data**

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://lit-inlet-70387.herokuapp.com/clima?lugar=london)

## README

Se creo una apliacion con la cual es posible consulta el clima de la ciudad que desee segun el reporte de la API gratuita de https://openweathermap.org/ de **Current Weather Data** para poder realizar esto el diseño se llevo acabo de la siguiente forma:
1. Como es de costumbre se genero el proyecto desde Maven
2. Posteriormente se conecto con el repositorio en git hub
3. Se configuro el achivo pom de esta forma: 

```
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>edu.escuelaing.arep.parcial.app</groupId>
  <artifactId>Parcial1</artifactId>
  <packaging>jar</packaging>
  <version>1.0-SNAPSHOT</version>
  <name>Parcial1</name>
  <url>http://maven.apache.org</url>
  <properties>
     <maven.compiler.source>1.8</maven.compiler.source>
     <maven.compiler.target>1.8</maven.compiler.target>
</properties>
  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>3.8.1</version>
      <scope>test</scope>
    </dependency>
	<dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.12</version>
      <scope>test</scope>
    </dependency>
	<dependency>
        <groupId>com.sparkjava</groupId>
        <artifactId>spark-core</artifactId>
        <version>2.7.2</version>
    </dependency>
  </dependencies>
  <reporting>
	<plugins>
	<plugin>
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-javadoc-plugin</artifactId>
	<version>2.10.1</version>
	</plugin>
	</plugins>
  </reporting>
	<build>
        <plugins>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-javadoc-plugin</artifactId>
			<version>2.10.1</version>
		</plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-jar-plugin</artifactId>
            <version>3.0.2</version>
            <configuration>
                <archive>
                    <manifest>
                        <mainClass>edu.escuelaing.arep.Lab1.app.App</mainClass>
                    </manifest>
                </archive>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-compiler-plugin</artifactId>
            <version>3.7.0</version>
            <configuration>
                <source>1.8</source>
                <target>1.8</target>
                <optimize>true</optimize>
                <debug>true</debug>
            </configuration>
        </plugin>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-dependency-plugin</artifactId>
            <version>3.0.2</version>
            <executions>
                <execution>
                    <id>copy-dependencies</id>
                    <phase>package</phase>
                    <goals>
                        <goal>copy-dependencies</goal>
                    </goals>
                </execution>
            </executions>
        </plugin>
        </plugins>
    </build>
</project>
```

4. Posteriormente se realizo el desarrollo de cada una de las clases que se deseaban y requerian para el correcto funcioamiento, resumiendose en los componentes y la Aplicacion principal
	+ Los componentes se tratan de la conneccion con la API gratuita de https://openweathermap.org/ de **Current Weather Data** lo cual se realizo con dos clases usando como interface HTTP Connection
	+ Ademas de usar una clase para el cache y asi cumplir con el requerimiento de buscar en las consultas ya realizadas

5. Se realizo el debido despliegue con heroku desde la consola
Pero primeramente compilando con **Maven**

![](./resources/compila.PNG)

y posteriormente empaquetado con **Maven**

![](./resources/empaquetado.PNG)

Para posteriormente realizar el despliegue:

![](./resources/despliegue.PNG)

Si todo esta en orden debera verse de la siguiente manera:

![](./resources/ejemplo.PNG)

Algunos ejemplos:
```
https://lit-inlet-70387.herokuapp.com/clima?lugar=bogota
https://lit-inlet-70387.herokuapp.com/clima?lugar=medellin
https://lit-inlet-70387.herokuapp.com/clima?lugar=paris
https://lit-inlet-70387.herokuapp.com/clima?lugar=london
```



### Pre requisitos 

Es necesario contar con los siguientes programas para poder compilar, ejecutar y testar el proyecto:
+ Maven 3.6.3
+ Java 1.8.0
+ Git 2.25.0windows.1
+ jdl1.8.0_251


De esta forma es posible verificarla version de mvn y asi es como debe verse:

```

$ mvn -version

Apache Maven 3.6.3 (cecedd343002696d0abb50b32b541b8a6ba2883f)
Maven home: C:\Program Files\Java\apache-maven-3.6.3-bin\apache-maven-3.6.3
Java version: 14.0.2, vendor: Oracle Corporation, runtime: C:\Program Files\Java\jdk-14.0.2
Default locale: es_CO, platform encoding: Cp1252
OS name: "windows 10", version: "10.0", arch: "amd64", family: "windows"

```

Para verificar a version de Java se verifica de la siguiente manera:
```

$java -version

java version "1.8.0_261"
Java(TM) SE Runtime Environment (build 1.8.0_261-b12)
Java HotSpot(TM) 64-Bit Server VM (build 25.261-b12, mixed mode)

```


## Enunciado

TALLER DE VERIFICACIÓN DE CONOCIMIENTOS TÉCNICOS
REQUERIMIENTOS
Su compañía lo ha seleccionado para construir un simple webservice desplegada en Heroku para uno de los clientes más importantes.

Así, han decidido que usted debe construir un webservice  para consultar el estado del clima en lugares específicos de la tierra.  El servicio web recibirá en un campo la descripción de una ciudad, por ejemplo “London” para Londres   y deberá mostrar la información del clima para esa ciudad. Para esto utilice el API gratuito de https://openweathermap.org/ (Puede crear una cuenta para obtener la llave para realizar consultas). Se le pide que su implementación sea eficiente en cuanto a recursos así que debe implementar un caché que permita evitar hacer consultas repetidas al API externo. La petición debe pasar por su servicio web desplegado en Heroku, es decir desde su servicio en Heroku se debe invocar el servicio web de clima. El usuario no sabrá qué servicio está usted invocando por detrás. Utilice el servicio "Current Weather Data".

Debe usar spark o sockets.

El API de su servicio debe ser el siguiente:
{url del servicio en heroku}/clima?lugar={ciudad o lugar}

El servicio debe reornar un Json exactamente igual al que retorna el servicio de openweathermap denominado "Current Weather Data". Asegurese que el tipo de retorno sea Json.

Sugerencia realice la implementación de manera incremental. Haga commits regulares.

Entregue todo en GIT HUB y el enlace a Heroku.

JSON
https://www.w3schools.com/js/js_json_syntax.asp


## Pruebas

Se realizaron una serie de pruebas con el conjunto de numeros ubicado en [Pruebas.txt](https://github.com/DonSantiagoS/LAB1AREP.git/Pruebas.txt)

arrojando los siguientes resultados

usando este codigo como proyeccion de las pruebas que se realizaron:

```
```


## Construccion

* [Maven](https://maven.apache.org/) - Dependency Management
* [Git](https://git-scm.com/) - Used to execute, test and compile as console
* [Heroku] (https://heroku.com) - Used to deploy

## Control de versiones

por: [Santiago Buitrago](https://github.com/DonSantiagoS) 

Version: 1.0
Fecha: 17 de febrero 2021

## Autor

* **Santiago Buitrago** - *Laboratorio N°1* - [DonSantiagoS](https://github.com/DonSantiagoS)

See also the list of [contributors](https://github.com/your/project/contributors) who participated in this project.

## Licencia 

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details

## Agradecimientos

* Persistencia en lograr el objetivo


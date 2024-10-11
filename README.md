# proyecto1: CheemsMart.
====================
Materia: Modelado y Programación.

## Descripción.
El proyecto consiste en diseñar una tienda completa llamada CheemsMart, se usarán los siguientes patrones:

* `Proxy:` Para definir una relación cliente-servidor para el paso de datos. En este caso para el catalogo de productos. [(more info)](https://refactoring.guru/es/design-patterns/proxy).
* `Strategy:` Para estructurar una linea de herencia entre varios algoritmos empleando interfaces y sus implementaciones, el objetivo es que se puedan modificar ciertos objetos en tiempo de ejecución y tambien promover la modularidad. En este caso será para los idiomas de cada país.[(more info)](https://refactoring.guru/es/design-patterns/strategy).
* `Observer:` Para establecer una relación observadores-objeto donde cada novedad del objeto representa una actualización de información para los observadores, el objetivo es que el sujeto sea un ente independiente de sus observadores. En este caso para mandarles ofertas a los clientes. [(more info)](https://refactoring.guru/es/design-patterns/observer).
* `Decorator:` Para ampliar dinamicamente la estructura de un objeto sin cambiar esencialmente la estructura basica de su clase. En este caso para aplicar ofertas sobre los productos. [(more info)](https://refactoring.guru/es/design-patterns/decorator).
* `Builder:` Para definir la configuración de un objeto paso por paso. En este caso para armar los carritos de compra [(more info)](https://refactoring.guru/es/design-patterns/builder).
* `Abstract Factory:` Para definir familias de objetos correlacionados. En este caso para los productos de la tienda. [(more info)](https://refactoring.guru/es/design-patterns/abstract-factory).
* `Singleton:` Para definir una instancia unica de una clase. En este caso para tener un único catalogo y una única lista de clientes. [(more info)](https://refactoring.guru/es/design-patterns/singleton).


## Equipo: Christian.
Colaboradores:
* `Leon Navarrete Adam Edmundo.`
* `Rubio Resendiz Marco Antonio.`
* `Valencia Pérez Guillermo Emanuel.`

## Para los colaboradores:
Primero que nada clonen el repositorio:
```
$ git clone https://github.com/Tocny/practica4
$ cd practica2/
```

Ya se los he dicho pero lo repito, AHUEVO TIENEN QUE TRABAJAR EN UNA RAMA. Si no lo hacen hay tabla >:l
De preferencia que la rama se llame como ustedes.
```
$ git branch nombre
$ git checkout nombre
```
Repito, esto es AHUEVO.

### En caso de errores de autenticación.
Cuando clonen o pusheen en el repositorio (en su rama) es posible que se topen con una cosa como esta cuando les pida la contraseña:
```
$ tocny@debian-Marco:~/Documentos/Code/Modelado/p1/practica1$ git push origin marco
$ Username for 'https://github.com': Tocny
$ Password for 'https://Tocny@github.com': 
$ remote: Support for password authentication was removed on August 13, 2021.
$ remote: Please see https://docs.github.com/get-started/getting-started-with-git/about-remote-repositories#cloning-with-https-urls for information on currently recommended modes of authentication.
$ fatal: Autenticación falló para 'https://github.com/Tocny/practica1/'
```
Esto es, como se puede leer, porque ahora github no usa la contraseña de su cuenta para autentificarlos. Ahora se utiliza un token.

Si presentan este problema wachense [este video](https://www.youtube.com/watch?v=2nzOI-ynXF4&t=308s), donde pueden ver como generarlo y como usarlo, conserven bien ese token para que no anden batallando.


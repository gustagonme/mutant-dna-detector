# mutant-dna-detector
Aplicación para detectar el ADN Mutante.

### Preparación del ambiente

#### Pre-requisitos:
- Docker
- Jdk mínimo v.8
- Gradle 7.4.1 o en su defecto el IDE Intelij Idea
- Git
- Postman

Links de instaladores: 
- Docker: https://www.docker.com/products/docker-desktop/
- JDK: https://www.oracle.com/co/java/technologies/javase/javase8-archive-downloads.html
- Intelij: https://www.jetbrains.com/es-es/idea/
- Git: https://git-scm.com/downloads 
- Postman: https://www.postman.com/downloads/

En caso de tener Linux, optar por usar SDKMAN o Brew Para instalar gradle. 

### Pasos para correr el proyecto: 

1. Abrir una consola de comandos o terminar y clonar el proyecto con el siguiente comando: 
    git clone https://github.com/gustagonme/mutant-dna-detector.git

2. Una vez clonado, desde la misma terminal nos dirigimos a la carpeta del proyecto.

3. Dentro de la carpeta del proyecto ejecutaremos los siguientes comandos. 
    ./gradlew build
    ./gradlew bootRun

4. Importar en postman los siguientes Curl, para ello vamos a File -> import... -> Raw text y pegamos cada uno de los Curl, recuerda pegar uno a la vez.

#### Método para validar cadena de adn y almacenar muestra:
curl --location --request POST 'https://localhost:8112/mutant/' \ --header 'Content-Type: application/json' \
--data-raw '
{ "dna":["ATGTGA","CAGTGC","TTATGT","AGAGCG","CCCGTA","TGTCTC"] }'
   
#### Método Status:
curl --location --request GET 'https://localhost:8112/mutant/status'

Nota: En caso de no funcionar los comandos de consola, abre el proyecto en el IDE Intelij, una vez abierto ubicas el archivo
com/mutant/dna/detector/MutantDnaDetectorApplication.java, le das clic derecho -> Run MutantDnaDetectorApplication... main()
y listo! el servidor estará arriba con las configuraciones propias de Intelij En gradle y java. 


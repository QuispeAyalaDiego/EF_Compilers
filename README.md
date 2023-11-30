# EF_Compilers

Examen Final 
Información del Estudiante
Nombre:Quspe Ayala Diego
Usuario: u202021294
Descripción del Proyecto
Este proyecto es un compilador para un pequeño lenguaje de programación diseñado como parte del examen final. El lenguaje soporta estructuras condicionales IF y expresiones en notación prefijo. Además, se definen palabras reservadas y se incluyen al menos cuatro operadores.

Marco Teórico
El proyecto se basa en el diseño y la implementación de un compilador para un lenguaje de programación específico. Un compilador es una herramienta que traduce un programa escrito en un lenguaje de programación (lenguaje fuente) a otro lenguaje (lenguaje objetivo), normalmente código máquina o un código intermedio. Los componentes clave de este compilador incluyen:

Analizador Léxico y Sintáctico: Utiliza ANTLR4 para analizar el lenguaje fuente y generar un árbol sintáctico abstracto (AST). Generador de Código IR: Transforma el AST en una representación intermedia (IR) utilizando LLVM, facilitando la optimización y generación de código objetivo. Optimizador de Código: Mejora el código IR para la eficiencia del tiempo de ejecución y la utilización de recursos. Ejecutor en Tiempo Real: Permite la ejecución del código fuente de manera interactiva, lo que es crucial para la depuración y la ejecución de pruebas.

Componentes del Proyecto
Analizador Sintáctico y Léxico (5 puntos):

Se utiliza ANTLR4 para generar un lexer y un parser basados en una gramática definida SimpleLanguage.g4  . Este componente se encarga del análisis sintáctico y léxico del lenguaje.

Generación de Código IR (5 puntos):
Implementación enS impleLanguageBaseListener.java
Optimización de Código (5 puntos):
Se borro y optimizaron distintos apartados del codigo para que funcione en impleLanguageBaseListener.java 

Ejecución en Tiempo Real (3 puntos):
El coddigo se ejecuto sin embargo no se llego a una depurracion satisfactoria

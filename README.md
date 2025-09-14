# Modelo de Software para empresa de logística

Este proyecto implementa un sistema logístico inspirado en la empresa ficticia BestEffort S.A., desarrollado como trabajo práctico para la materia *Algoritmos y Estructura de Datos II* en la Universidad de Buenos Aires (UBA).

## 🚚 Descripción

El sistema modela una red completa de ciudades y gestiona traslados de productos entre ellas. Cada traslado tiene atributos como ganancia, antigüedad y origen/destino. Se prioriza el despacho eficiente según criterios de rentabilidad y tiempo, evitando inanición algorítmica.

## 🧩 Estructuras implementadas

- **Heap personalizado** para selección eficiente de traslados.
- **Handles** para acceso directo y eficiente a elementos dentro del heap. Permiten modificar o eliminar traslados sin recorrer toda la estructura, manteniendo complejidad logarítmica.
- **Módulos auxiliares** para encapsulamiento y claridad.

## ⚙️ Funcionalidades principales

- Registrar traslados nuevos.
- Despachar los más redituables o más antiguos.
- Calcular estadísticas:
  - Ciudad con mayor ganancia, pérdida y superávit.
  - Ganancia promedio global.

## 📈 Complejidades

Todas las operaciones cumplen con las complejidades requeridas por el enunciado, justificadas en los comentarios del código. Se evita el uso de clases predefinidas, salvo las permitidas (ArrayList, String).

## 🧪 Tests

Incluye casos de prueba propios además de los provistos, para validar:
- Correctitud de despacho.
- Cálculo de estadísticas.
- Robustez ante entradas inválidas.

## 👥 Autores

- Arango Joaquin.
- Echave Mendez Manuel.
- Peix Francisco.
- Salfity Juliana María.


Trabajo grupal realizado por estudiantes de la UBA. Este repositorio refleja habilidades en diseño algorítmico, programación en Java, modularidad, y análisis de complejidad.

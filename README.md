- Alumno = Romina Valdés 
- Rol = 202473517-9

# Sobre métodos
- mantuve métodos aunque no se utilicen directamente en la ejecución del flujo
Métodos:
- checkDanoSeguro() en EnemigoSimulador
- algunos métodos utilizados para combate grupal
- métodos de validación de accesos entre zonas
- tambien utilice @SuppressWarnings("resource") en Scanner que utilizan System.in para evitar tener que cerrar un Scanner, porque si lo cerraba no se leerian las demás opciones de la consola.

# Enemigos en Sector 7
- aplique probabilidad en los enemigos de este sector, con un 90% de ocurrencia para combate con un enemigo holográfico y un 10% para combate en grupo, es decir, cloud se enfrenta a dos enemigos holográficos.

# Ejecución
Seguir estos pasos:
- make
- make run
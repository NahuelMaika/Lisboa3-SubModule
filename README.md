# Lisboa3-SubModule

Para utilizar el servicio externo ofrecido "LastFmService" es necesario utilizar la funcion pública disponible en LastFmInjector: getService(). Esta función se encarga de realizar la inicialización completa del servicio, inyectando las dependencias correspondientes previo a obtenerlo, por lo que para obtener el servicio funcional solo debería quedar una linea de la siguiente forma:

lastFmService = LastFmInjector.getService()

Una vez obtenido el servicio lastFmService, la utilizacion del mismo es muy sencilla. Para obtener una entidad LastFmArtistInfo asociada a un artista solo deben realizarse dos pasos:

val lastFmArtistInfo = lastFmService.getArtistInfo(artistName) // Se obtiene la entidad con la funcion

val card = adaptLastFmArtistInfoToCard(lastFmArtistInfo) // Se realiza la adaptación a la card

=> Luego del mapeo a una card, el manejo de la misma es independiente.

# Lisboa3-SubModule

Para utilizar el servicio externo ofrecido "LastFmService" es necesario utilizar la funcion pública disponible en LastFmInjector: getService(). Esta función se encarga de realizar la inicialización completa del servicio, inyectando las dependencias correspondientes previo a obtenerlo, por lo que para obtener el servicio funcional solo debería quedar una linea de la siguiente forma:

**lastFmService = LastFmInjector.getService()**

Una vez obtenido el servicio lastFmService, la utilizacion del mismo es muy sencilla. Para obtener una entidad LastFmArtistInfo asociada a un artista solo deben realizarse una llamada a la función getArtistInfo():

**val lastFmArtistInfo = lastFmService.getArtistInfo(artistName)**

Los tipos de resultado que pueden obtenerse son:
* Una entidad **LastFmArtistInfo**, en caso de existir.
* **NULL**, en caso de que la búsqueda no sea exitosa.

La url de la imagen de LastFm puede obtenerse a traves de la constante publica LAST_FM_DEFAULT_IMAGE en LastFmArtistInfo.

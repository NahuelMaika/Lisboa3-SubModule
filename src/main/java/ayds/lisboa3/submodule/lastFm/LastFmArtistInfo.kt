package ayds.lisboa3.submodule.lastFm

private const val LAST_FM_DEFAULT_IMAGE = "https://upload.wikimedia.org/wikipedia/commons/thumb/d/d4/Lastfm_logo.svg/320px-Lastfm_logo.svg.png"

data class LastFmArtistInfo (
    var bioContent : String,
    var url : String,
    val logo: String = LAST_FM_DEFAULT_IMAGE,
)
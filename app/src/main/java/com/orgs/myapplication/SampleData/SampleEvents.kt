import com.orgs.myapplication.Model.Evento

val sampleEvents: List<Evento> = listOf(
    Evento(titulo = "Evento 1", descricao = "Descrição do evento 1"),
    Evento(titulo = "Evento 2", descricao = "Descrição do evento 2"),
    Evento(titulo = "Evento 3"),
    Evento(titulo = "Evento 4"),
    Evento(titulo = "Evento 5"),

)

val sampleEventsProximos: List<Evento> = listOf(
    Evento(titulo = "Evento Proximo 1"),
    Evento(titulo = "Evento Proximo 1"),
    Evento(titulo = "Evento Proximo 1"),
    Evento(titulo = "Evento Proximo 1")

    )

val sampleSection = mapOf(
    "Todos" to sampleEvents,
    "Próximos" to sampleEventsProximos

)
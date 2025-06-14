import br.com.alura.aluvery.dao.User
import com.orgs.myapplication.Model.Evento
import com.orgs.myapplication.R

val sampleEvents: List<Evento> = listOf(
    Evento(titulo = "Evento 1", descricao = "Descrição do evento 1"),
    Evento(titulo = "Evento 2", descricao = "Descrição do evento 2"),
    Evento(titulo = "Evento 3"),
    Evento(titulo = "Evento 4"),
    Evento(titulo = "Evento 5"),
    Evento(titulo = "Evento 6"),
    Evento(titulo = "Evento 7"),
    Evento(titulo = "Evento 8"),
    Evento(titulo = "Evento 9"),
    Evento(titulo = "Evento 10"),

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

val sampleUsers = listOf(
    User(nome = "ALexia", imagem = R.drawable.avatar_1),
   User(nome = "Diego", imagem = R.drawable.avatar_2),
    User(nome = "Cage", imagem = R.drawable.avatar_3),
    User(nome = "Ruan", imagem = R.drawable.avatar_4),
    User(nome = "Julia", imagem = R.drawable.avatar_5),
    User(nome = "Rodrigo", imagem = R.drawable.avatar_6),
    User(nome = "Sara", imagem = R.drawable.avatar_7),
    User(nome = "Joao", imagem = R.drawable.avatar_8),
    User(nome = "Gabriel", imagem = R.drawable.avatar_9),
    User(nome = "Maycon", imagem = R.drawable.avatar_10),

)
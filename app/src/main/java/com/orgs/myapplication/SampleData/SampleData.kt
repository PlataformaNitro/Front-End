import com.orgs.myapplication.Model.User
import com.orgs.myapplication.Model.Evento
import com.orgs.myapplication.Model.MotoClube
import com.orgs.myapplication.R

val sampleEvents: List<Evento> = listOf(
    Evento(titulo = " Encontro Nacional de Motociclistas", imagem = R.drawable.evento_1 ,descricao = "Prepare-se para o maior encontro de motociclistas do país! Shows de rock, área de camping, expositores e a verdadeira irmandade sobre duas rodas te esperam."),
    Evento(titulo = "Aniversário do Motoclube Águias do Asfalto", imagem = R.drawable.evento_2, descricao = "Celebre conosco mais um ano de estrada e liberdade! Música ao vivo, churrasco 0800 para motociclistas e troféus para motoclubes marcam nossa festa."),
    Evento(titulo = "Serra & Cerveja: Rota de Mototurismo", imagem = R.drawable.evento_3, descricao = "Um final de semana explorando as melhores serras da região, com paradas estratégicas para degustação de cervejas artesanais. Vagas limitadas!"),
    Evento(titulo = "Moto Rock Festival", imagem = R.drawable.motorock, descricao = "Adrenalina e rock'n'roll em um só lugar! As melhores bandas de rock, exposição de motos customizadas e um ambiente de pura energia. Garanta seu ingresso." ),
    Evento(titulo = "Bate e Fica Solidário", imagem = R.drawable.bateefica, descricao = "Pegue a estrada por uma boa causa. Passeio motociclístico com arrecadação de alimentos e confraternização no destino. Faça a diferença sobre duas rodas."),
    Evento(titulo = "Rota do Vinho de Moto", imagem = R.drawable.chatgpt_image_27_de_jun__de_2025__19_19_38, descricao = "Uma experiência única de mototurismo pelas principais vinícolas da região. Degustação, gastronomia e paisagens deslumbrantes te aguardam."),
    Evento(titulo = "Encontro de Triciclos e Motos Especiais", imagem = R.drawable.evento_1, descricao = "Um evento dedicado à diversidade sobre rodas. Venha exibir sua máquina ou simplesmente admirar os triciclos e motos mais exóticas do Brasil."),
    Evento(titulo = "Moto Camping Selvagem", imagem = R.drawable.evento_1, descricao = "Para os amantes da aventura! Rota off-road desafiadora com acampamento rústico sob as estrelas. Traga sua moto e seu espírito aventureiro."),
)

val sampleMecanicos: List<Evento> = listOf(
    Evento(titulo = " Encontro Nacional de Motociclistas", imagem = R.drawable.evento_1 ,descricao = "Prepare-se para o maior encontro de motociclistas do país! Shows de rock, área de camping, expositores e a verdadeira irmandade sobre duas rodas te esperam."),
    Evento(titulo = "Aniversário do Motoclube Águias do Asfalto", imagem = R.drawable.evento_2, descricao = "Celebre conosco mais um ano de estrada e liberdade! Música ao vivo, churrasco 0800 para motociclistas e troféus para motoclubes marcam nossa festa."),
    Evento(titulo = "Serra & Cerveja: Rota de Mototurismo", imagem = R.drawable.evento_3, descricao = "Um final de semana explorando as melhores serras da região, com paradas estratégicas para degustação de cervejas artesanais. Vagas limitadas!"),
    Evento(titulo = "Moto Rock Festival", imagem = R.drawable.motorock, descricao = "Adrenalina e rock'n'roll em um só lugar! As melhores bandas de rock, exposição de motos customizadas e um ambiente de pura energia. Garanta seu ingresso." ),
    Evento(titulo = "Bate e Fica Solidário", imagem = R.drawable.bateefica, descricao = "Pegue a estrada por uma boa causa. Passeio motociclístico com arrecadação de alimentos e confraternização no destino. Faça a diferença sobre duas rodas."),
    Evento(titulo = "Rota do Vinho de Moto", imagem = R.drawable.chatgpt_image_27_de_jun__de_2025__19_19_38, descricao = "Uma experiência única de mototurismo pelas principais vinícolas da região. Degustação, gastronomia e paisagens deslumbrantes te aguardam."),
    Evento(titulo = "Encontro de Triciclos e Motos Especiais", imagem = R.drawable.evento_1, descricao = "Um evento dedicado à diversidade sobre rodas. Venha exibir sua máquina ou simplesmente admirar os triciclos e motos mais exóticas do Brasil."),
    Evento(titulo = "Moto Camping Selvagem", imagem = R.drawable.evento_1, descricao = "Para os amantes da aventura! Rota off-road desafiadora com acampamento rústico sob as estrelas. Traga sua moto e seu espírito aventureiro."),
)



val sampleEventsProximos: List<Evento> = listOf(
    Evento(titulo = "Evento Proximo 1", imagem = R.drawable.evento_1),
    Evento(titulo = "Evento Proximo 1", imagem = R.drawable.evento_1),
    Evento(titulo = "Evento Proximo 1", imagem = R.drawable.evento_1),
    Evento(titulo = "Evento Proximo 1", imagem = R.drawable.evento_1)

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

val sampleMotoClubes: List<MotoClube> = listOf(
    MotoClube(nome = "MotoClube 1", imagem = R.drawable.icebiker, descricao = "Descrição do evento 1"),
    MotoClube(nome = "MotoClube 2", imagem = R.drawable.anrjpi, descricao = "Descrição do evento 2"),
    MotoClube(nome = "MotoClube 3", imagem = R.drawable.maquinas_m, descricao = "Descrição do evento 3"),

)
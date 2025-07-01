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
    Evento(
        titulo = "Carlos da Oficina Rápida",
        imagem = R.drawable.moto_tool_1,
        descricao = "Especialista em manutenção preventiva e diagnósticos rápidos. Carlos tem mais de 15 anos de experiência cuidando de motos com agilidade e precisão."
    ),
    Evento(
        titulo = "Joana MotoTech",
        imagem = R.drawable.moto_tool_2,
        descricao = "Joana se destaca por seu trabalho detalhado em elétrica de motocicletas e customizações. Confiabilidade e inovação em cada serviço."
    ),
    Evento(
        titulo = "Oficina Irmãos Torque",
        imagem = R.drawable.moto_tool_3,
        descricao = "Dupla de irmãos apaixonados por mecânica. Atendimento completo com foco em motos esportivas e revisão completa."
    ),
    Evento(
        titulo = "Zé do Motor Forte",
        imagem = R.drawable.moto_tool_4,
        descricao = "Conhecido por sua paixão por motores, Zé é referência em retífica e aumento de performance para motos de média e alta cilindrada."
    ),
    Evento(
        titulo = "Beto da Bike Veloz",
        imagem = R.drawable.moto_tool_5,
        descricao = "Mecânico especializado em motos de trilha e motocross. Atendimento técnico, alinhamento de suspensão e preparação para competições."
    ),
    Evento(
        titulo = "Mariana Garage Custom",
        imagem = R.drawable.moto_tool_6,
        descricao = "Especialista em customização e estilo retrô. Mariana transforma qualquer moto em uma obra de arte sobre rodas."
    ),
    Evento(
        titulo = "André Mecânica Geral",
        imagem = R.drawable.moto_tool_7,
        descricao = "Serviços completos, desde troca de óleo até revisão de freios e embreagem. André é conhecido pela transparência e preços justos."
    ),
    Evento(
        titulo = "Dona Sônia MotoService",
        imagem = R.drawable.moto_tool_8,
        descricao = "Veterana na profissão, Dona Sônia alia experiência e carinho no cuidado com cada moto. Um nome respeitado entre os motociclistas."
    ),
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
    MotoClube(nome = "Abutres Moto Clube", imagem = R.drawable.motoclube_1, descricao = "Um dos maiores motoclubes do Brasil, fundado em São Paulo."),
    MotoClube(nome = "Bodes do Asfalto", imagem = R.drawable.motoclube_2, descricao = "Motoclube formado por maçons apaixonados por duas rodas."),
    MotoClube(nome = "Cavaleiros de Aço", imagem = R.drawable.motoclube_3, descricao = "Clube tradicional com forte presença em eventos nacionais."),
    MotoClube(nome = "Esquadrão do asfalto", imagem = R.drawable.motoclube_4, descricao = "Motociclistas cristãos que unem fé e estrada."),
    MotoClube(nome = "cobras de Aço", imagem = R.drawable.motoclube_5, descricao = "Grupo dedicado a grandes viagens e companheirismo."),
    MotoClube(nome = "lobos do Asfalto", imagem = R.drawable.motoclube_6, descricao = "Motoclube com foco em liberdade e estilo de vida biker."),
    MotoClube(nome = "Carpe Diem Moto Clube", imagem = R.drawable.motoclube_7, descricao = "Clube independente com presença marcante em trilhas."),
)


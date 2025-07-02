import com.orgs.myapplication.Model.User
import com.orgs.myapplication.Model.Evento
import com.orgs.myapplication.Model.Mecanico
import com.orgs.myapplication.Model.MotoClube
import com.orgs.myapplication.R

val sampleEvents: List<Evento> = listOf(
    Evento(
        titulo = "Encontro Nacional de Motociclistas",
        imagem = R.drawable.evento_1,
        descricao = "Prepare-se para o maior encontro de motociclistas do país! Shows de rock, área de camping, expositores e a verdadeira irmandade sobre duas rodas te esperam.",
        data = "12 de Agosto",
        hora = "10h",
        local = "Parque do Peão, Barretos - SP",
        preco = "R$ 30",
        categoria = "Festival",
        organizador = "Federação Brasileira de Motoclubes",
        participantes = 1200,
        tags = listOf("motos", "rock", "festival", "camping")
    ),
    Evento(
        titulo = "Aniversário do Motoclube Águias do Asfalto",
        imagem = R.drawable.evento_2,
        descricao = "Celebre conosco mais um ano de estrada e liberdade! Música ao vivo, churrasco 0800 para motociclistas e troféus para motoclubes marcam nossa festa.",
        data = "20 de Julho",
        hora = "14h",
        local = "Sede dos Águias, Goiânia - GO",
        preco = "Gratuito",
        categoria = "Comemoração",
        organizador = "Águias do Asfalto",
        participantes = 500,
        tags = listOf("motoclube", "festa", "churrasco", "rock")
    ),
    Evento(
        titulo = "Serra & Cerveja: Rota de Mototurismo",
        imagem = R.drawable.evento_3,
        descricao = "Um final de semana explorando as melhores serras da região, com paradas estratégicas para degustação de cervejas artesanais. Vagas limitadas!",
        data = "22 julho",
        hora = "07h",
        local = "Serra da Mantiqueira - MG",
        preco = "R$ 180 (pacote)",
        categoria = "Mototurismo",
        organizador = "MotoTrilhas MG",
        participantes = 80,
        tags = listOf("aventura", "serra", "cerveja", "turismo")
    ),
    Evento(
        titulo = "Moto Rock Festival",
        imagem = R.drawable.motorock,
        descricao = "Adrenalina e rock'n'roll em um só lugar! As melhores bandas de rock, exposição de motos customizadas e um ambiente de pura energia. Garanta seu ingresso.",
        data = "10 de Agosto",
        hora = "18h",
        local = "Arena Multiuso, Florianópolis - SC",
        preco = "R$ 50",
        categoria = "Festival",
        organizador = "Moto Rockers SC",
        participantes = 900,
        tags = listOf("rock", "motos", "shows", "custom")
    ),
    Evento(
        titulo = "Bate e Fica Solidário",
        imagem = R.drawable.bateefica,
        descricao = "Pegue a estrada por uma boa causa. Passeio motociclístico com arrecadação de alimentos e confraternização no destino. Faça a diferença sobre duas rodas.",
        data = "3 de Agosto",
        hora = "09h",
        local = "Saída: Posto BR - Destino: ONG Vida Melhor, Recife - PE",
        preco = "1kg de alimento",
        categoria = "Ação social",
        organizador = "Moto Solidários PE",
        participantes = 300,
        tags = listOf("solidariedade", "passeio", "beneficente")
    ),
    Evento(
        titulo = "Rota do Vinho de Moto",
        imagem = R.drawable.chatgpt_image_27_de_jun__de_2025__19_19_38,
        descricao = "Uma experiência única de mototurismo pelas principais vinícolas da região. Degustação, gastronomia e paisagens deslumbrantes te aguardam.",
        data = "24 de Agosto",
        hora = "08h",
        local = "Vale dos Vinhedos, Bento Gonçalves - RS",
        preco = "R$ 200 (inclui degustação)",
        categoria = "Mototurismo",
        organizador = "Vinho & Motor",
        participantes = 70,
        tags = listOf("vinho", "moto", "gastronomia", "turismo")
    ),
    Evento(
        titulo = "Encontro de Triciclos e Motos Especiais",
        imagem = R.drawable.evento_1,
        descricao = "Um evento dedicado à diversidade sobre rodas. Venha exibir sua máquina ou simplesmente admirar os triciclos e motos mais exóticas do Brasil.",
        data = "17 de Agosto",
        hora = "16h",
        local = "Praça das Nações, São Bernardo do Campo - SP",
        preco = "Gratuito",
        categoria = "Exposição",
        organizador = "Trike Brasil",
        participantes = 400,
        tags = listOf("triciclo", "exótico", "exposição", "custom")
    ),
    Evento(
        titulo = "Moto Camping Selvagem",
        imagem = R.drawable.evento_1,
        descricao = "Para os amantes da aventura! Rota off-road desafiadora com acampamento rústico sob as estrelas. Traga sua moto e seu espírito aventureiro.",
        data = "31 de Agosto a 1º de Setembro",
        hora = "06h",
        local = "Região de Chapada dos Veadeiros - GO",
        preco = "R$ 100 (inclui guia e camping)",
        categoria = "Aventura",
        organizador = "Trilheiros Cerrado",
        participantes = 60,
        tags = listOf("off-road", "acampamento", "aventura", "natureza")
    )
)


val sampleMecanicos: List<Mecanico> = listOf(
    Mecanico(
        nome = "Carlos da Oficina Rápida",
        imagem = R.drawable.moto_tool_1,
        descricao = "Especialista em manutenção preventiva e diagnósticos rápidos. Carlos tem mais de 15 anos de experiência cuidando de motos com agilidade e precisão.",
        especialidades = listOf("Manutenção preventiva", "Diagnóstico rápido", "Troca de óleo"),
        avaliacao = 4.7,
        contato = "(11) 99876-1234",
        horario = "Seg a Sab: 08h às 18h",
        experiencia = 15,
        destaque = listOf("Atendimento rápido", "Peças originais", "Orçamento na hora"),
        local = "São Paulo - SP"
    ),
    Mecanico(
        nome = "Joana MotoTech",
        imagem = R.drawable.moto_tool_2,
        descricao = "Joana se destaca por seu trabalho detalhado em elétrica de motocicletas e customizações. Confiabilidade e inovação em cada serviço.",
        especialidades = listOf("Elétrica", "Customização", "Painel digital"),
        avaliacao = 4.9,
        contato = "(21) 91234-5678",
        horario = "Seg a Sex: 09h às 17h",
        experiencia = 10,
        destaque = listOf("Inovação", "Garantia", "Design exclusivo"),
        local = "Rio de Janeiro - RJ"
    ),
    Mecanico(
        nome = "Oficina Irmãos Torque",
        imagem = R.drawable.moto_tool_3,
        descricao = "Dupla de irmãos apaixonados por mecânica. Atendimento completo com foco em motos esportivas e revisão completa.",
        especialidades = listOf("Revisão geral", "Motos esportivas", "Injeção eletrônica"),
        avaliacao = 4.8,
        contato = "(31) 98888-9999",
        horario = "Seg a Sab: 08h às 19h",
        experiencia = 8,
        destaque = listOf("Equipe ágil", "Peças importadas", "Mecânica esportiva"),
        local = "Belo Horizonte - MG"
    ),
    Mecanico(
        nome = "Zé do Motor Forte",
        imagem = R.drawable.moto_tool_4,
        descricao = "Conhecido por sua paixão por motores, Zé é referência em retífica e aumento de performance para motos de média e alta cilindrada.",
        especialidades = listOf("Retífica de motor", "Preparação", "Performance"),
        avaliacao = 4.6,
        contato = "(47) 91111-2222",
        horario = "Seg a Sex: 07h às 17h",
        experiencia = 20,
        destaque = listOf("Alta performance", "Motores preparados", "Experiência comprovada"),
        local = "Joinville - SC"
    ),
    Mecanico(
        nome = "Beto da Bike Veloz",
        imagem = R.drawable.moto_tool_5,
        descricao = "Mecânico especializado em motos de trilha e motocross. Atendimento técnico, alinhamento de suspensão e preparação para competições.",
        especialidades = listOf("Trilha", "Motocross", "Suspensão"),
        avaliacao = 4.5,
        contato = "(62) 93456-7890",
        horario = "Seg a Dom: 08h às 18h",
        experiencia = 11,
        destaque = listOf("Off-road", "Corridas", "Alinhamento de suspensão"),
        local = "Goiânia - GO"
    ),
    Mecanico(
        nome = "Mariana Garage Custom",
        imagem = R.drawable.moto_tool_6,
        descricao = "Especialista em customização e estilo retrô. Mariana transforma qualquer moto em uma obra de arte sobre rodas.",
        especialidades = listOf("Customização", "Pintura retrô", "Estilo bobber"),
        avaliacao = 5.0,
        contato = "(51) 99888-1122",
        horario = "Seg a Sex: 10h às 19h",
        experiencia = 7,
        destaque = listOf("Estilo retrô", "Design único", "Atendimento personalizado"),
        local = "Porto Alegre - RS"
    ),
    Mecanico(
        nome = "André Mecânica Geral",
        imagem = R.drawable.moto_tool_7,
        descricao = "Serviços completos, desde troca de óleo até revisão de freios e embreagem. André é conhecido pela transparência e preços justos.",
        especialidades = listOf("Freios", "Embreagem", "Troca de óleo"),
        avaliacao = 4.3,
        contato = "(16) 90000-3333",
        horario = "Seg a Sab: 08h às 18h",
        experiencia = 9,
        destaque = listOf("Preço justo", "Serviço completo", "Atendimento confiável"),
        local = "Ribeirão Preto - SP"
    ),
    Mecanico(
        nome = "Dona Sônia MotoService",
        imagem = R.drawable.moto_tool_8,
        descricao = "Veterana na profissão, Dona Sônia alia experiência e carinho no cuidado com cada moto. Um nome respeitado entre os motociclistas.",
        especialidades = listOf("Revisão geral", "Limpeza de carburador", "Troca de relação"),
        avaliacao = 4.9,
        contato = "(85) 93456-4444",
        horario = "Seg a Sex: 08h às 17h",
        experiencia = 25,
        destaque = listOf("Tradição", "Cuidado no detalhe", "Respeitada na comunidade"),
        local = "Fortaleza - CE"
    )
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
    User(
        nome = "ALexia",
        imagem = R.drawable.avatar_1,
        bio = "Apaixonada por trilhas e aventura.",
        moto = "Yamaha Ténéré",
        tipo = "Trail",
        totalKm = 9800
    ),
    User(
        nome = "Diego",
        imagem = R.drawable.avatar_2,
        bio = "Celebro minha paixão sobre duas rodas.",
        moto = "Sahara 300",
        tipo = "Adventure",
        totalKm = 12450
    ),
    User(
        nome = "Cage",
        imagem = R.drawable.avatar_3,
        bio = "Viajante urbano e fã de motos clássicas.",
        moto = "Harley Davidson",
        tipo = "Cruiser",
        totalKm = 15000
    ),
    User(
        nome = "Ruan",
        imagem = R.drawable.avatar_4,
        bio = "Adoro velocidade e estradas abertas.",
        moto = "Kawasaki Ninja",
        tipo = "Esportiva",
        totalKm = 8900
    ),
    User(
        nome = "Julia",
        imagem = R.drawable.avatar_5,
        bio = "Mãe e aventureira, sempre pronta para a próxima viagem.",
        moto = "Honda CB500X",
        tipo = "Adventure",
        totalKm = 11000
    ),
    User(
        nome = "Rodrigo",
        imagem = R.drawable.avatar_6,
        bio = "Explorador nato, vive para a liberdade.",
        moto = "BMW GS",
        tipo = "Adventure",
        totalKm = 20000
    ),
    User(
        nome = "Sara",
        imagem = R.drawable.avatar_7,
        bio = "Curto passeios tranquilos no fim de semana.",
        moto = "Vespa Primavera",
        tipo = "Scooter",
        totalKm = 5400
    ),
    User(
        nome = "Joao",
        imagem = R.drawable.avatar_8,
        bio = "Amo sentir o vento na estrada.",
        moto = "Ducati Monster",
        tipo = "Naked",
        totalKm = 7800
    ),
    User(
        nome = "Gabriel",
        imagem = R.drawable.avatar_9,
        bio = "Motociclista urbano e entusiasta da manutenção.",
        moto = "Suzuki GSX-R",
        tipo = "Esportiva",
        totalKm = 9800
    ),
    User(
        nome = "Maycon",
        imagem = R.drawable.avatar_10,
        bio = "Viajante de longa distância e aventureiro.",
        moto = "Triumph Tiger",
        tipo = "Adventure",
        totalKm = 17000
    )
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


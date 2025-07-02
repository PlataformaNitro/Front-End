package com.orgs.myapplication.Model

data class Mecanico(
    val imagem: Int = 1,                          // ID da imagem do mecânico/oficina
    val nome: String,                             // Nome do mecânico ou oficina
    val descricao: String = "Descrição do serviço", // Breve descrição
    val especialidades: List<String> = listOf(),  // Lista de especialidades
    val avaliacao: Double = 0.0,                  // Nota de avaliação (ex: 4.7)
    val contato: String = "",                     // Telefone, WhatsApp etc.
    val horario: String = "",                     // Horário de funcionamento
    val experiencia: Int = 0,                     // Anos de experiência
    val destaque: List<String> = listOf(),        // Itens de destaque
    val local: String = ""                        // Localização (cidade, bairro)
)

package com.orgs.myapplication.Model

data class Evento(
    val imagem: Int = 1,                  // Imagem do evento (ID do recurso)
    val titulo: String,                   // Título do evento
    val descricao: String = "Descrição do evento",  // Descrição curta

    val data: String = "20 de Julho",     // Data do evento
    val hora: String = "15h",             // Horário de início
    val local: String = "Local do evento", // Nome do local/cidade
    val preco: String = "Gratuito",       // Preço ou entrada
    val categoria: String = "Encontro",   // Categoria (show, palestra, etc.)
    val organizador: String = "Organizador", // Nome do organizador
    val participantes: Int = 0,           // Número de participantes confirmados
    val tags: List<String> = listOf(),    // Lista de tags (moto, música, etc.)
)

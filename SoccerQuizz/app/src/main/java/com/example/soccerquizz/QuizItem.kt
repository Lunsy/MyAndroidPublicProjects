package com.example.soccerquizz

class QuizItem {

    var question: String
    var answerList: List<String>

    constructor(question: String, answer: List<String>){
        this.question = question
        this.answerList = answer
    }
}
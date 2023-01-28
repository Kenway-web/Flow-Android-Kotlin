package com.example.flowproject


import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow


fun getNotes(): Flow<Note> {

    val list= listOf(
        Note(1,true,"First","First Description"),
        Note(2,true,"Second","Second Description"),
        Note(3,false,"Third","Third Description")
    )
    return  list.asFlow()
}

data class Note(val id:Int,val isActive:Boolean,val tittle:String,val description:String)
data class FormattedNote(val isActive: Boolean,val tittle: String, val description: String)
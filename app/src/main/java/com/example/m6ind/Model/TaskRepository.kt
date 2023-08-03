package com.example.m6ind.Model

import androidx.lifecycle.LiveData

// responsabilidad exponer los datos para el ViewModel
class TaskRepository (private val taskDao: TaskDao){


    // Este value va a contener toda la información de la BD todas las tareas
    val listAllTask: LiveData<List<Task>> = taskDao.getAllTask1()


    suspend fun  inserTask(task: Task){

        taskDao.insertTask(task)
    }


    suspend fun updateTask(task: Task){

        taskDao.updateTask(task)
    }


    suspend fun deleteAllTask(){

        taskDao.deletAll()
    }




}
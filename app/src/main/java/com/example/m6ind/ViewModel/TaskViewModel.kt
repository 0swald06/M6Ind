package com.example.m6ind.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.m6ind.Model.Task
import com.example.m6ind.Model.TaskDataBase
import com.example.m6ind.Model.TaskRepository
import kotlinx.coroutines.launch


class TaskViewModel(application: Application): AndroidViewModel(application){

    // conexión con el repositorio

    private val repository : TaskRepository

    // LIVE DATA QUE EXPONE LA INFO DEL MODELO

    val allTask : LiveData<List<Task>>



    init{

        // obteniendo instancia del dao
        val TaskDao = TaskDataBase.getDatabase(application).getTaskDao()
        repository = TaskRepository(TaskDao)
        allTask = repository.listAllTask

    }


    fun inserTask(task: Task)= viewModelScope.launch {
        repository.inserTask(task)
    }


    fun updateTask(task: Task)= viewModelScope.launch {

        repository.updateTask(task)
    }


    fun deleteTask()= viewModelScope.launch {

        repository.deleteAllTask()
    }




    // Para seleccionar algun Elemento
    private val selectedTask : MutableLiveData<Task?> = MutableLiveData()



    // funcion para recibir una tarea seleccionada desde el Rv
    fun selected(task: Task?){
        // guarda lo que estamos seleccionando
        selectedTask.value= task
    }


    // para mostrar los elementos luego de una seleccion Recibir  el objeto seleccionado
    fun selectedItem(): LiveData<Task?> = selectedTask



}
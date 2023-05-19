package com.marcos.demo.services;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marcos.demo.models.Task;
import com.marcos.demo.models.User;
import com.marcos.demo.repository.TaskRepository;


@Service
public class TaskService {
 
    @Autowired
    private TaskRepository trakRepository;

    @Autowired
    private UserService userService;

    public Task findById(Long id){
     Optional<Task> task = this.trakRepository.findById(id);
     return task.orElseThrow(()-> new RuntimeException(
        "Tarefa não encontrada! id: " + id + ", Tipo: " + Task.class.getName()
     ));}

     @Transactional
     public Task create(Task obj){
        User user = this.userService.findById((obj.getUser().getId()));
        obj.setId(null);
        obj.setUser(user);
        obj = this.trakRepository.save(obj);
        return obj;
     }

     @Transactional
     public Task update(Task obj){
      Task newObj = findById(obj.getId());
      newObj.setDescription(obj.getDescription());
      return this.trakRepository.save(newObj);
     }

     public void delete(Long id){
         findById(id);
         try{
            this.trakRepository.deleteById(id);
         }catch(Exception e){
               throw new RuntimeException("não é possível excluir!");
         }


     }

}

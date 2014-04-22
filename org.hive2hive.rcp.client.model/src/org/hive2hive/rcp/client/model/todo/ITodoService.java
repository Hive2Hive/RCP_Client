package org.hive2hive.rcp.client.model.todo;

import java.util.List;

public interface ITodoService {

	Todo getTodo(long id);

	boolean saveTodo(Todo todo);

	boolean deleteTodo(long id);

	List<Todo> getTodos();

}

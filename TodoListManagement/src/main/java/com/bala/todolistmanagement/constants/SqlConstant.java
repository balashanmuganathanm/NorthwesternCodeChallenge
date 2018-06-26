package com.bala.todolistmanagement.constants;

public class SqlConstant {

	//TODO: Inject the SQL from file
		public static final String CREATE_LIST_SQL = "INSERT INTO public.todo_list(\r\n" + 
				"            list_id, category, description, created_timestamp)\r\n" + 
				"    VALUES (nextval('public.list_seq'), :category, :description, current_timestamp) \r\n" + 
				"RETURNING list_id AS listId;";

		public static final String UPDATE_LIST_SQL = "UPDATE public.todo_list \r\n" + 
				"   SET category = :category,\r\n" + 
				"    description = :description,\r\n" + 
				"    last_updated_timestamp = current_timestamp\r\n" + 
				"WHERE list_id = :listId RETURNING list_id AS listId;";

		public static final String DELETE_LIST_SQL = "DELETE FROM public.todo_list WHERE list_id = :listId "
				+ "RETURNING list_id AS listId;";
		
		public static final String CREATE_ITEM_SQL = "INSERT INTO public.todo_item(\r\n" + 
				"            item_id, list_id, status, description, created_timestamp)\r\n" + 
				"    VALUES (nextval('public.item_seq'), :listId, :status, :description, current_timestamp)\r\n" + 
				"RETURNING item_id AS itemId;";
		
		public static final String UPDATE_ITEM_SQL = "UPDATE public.todo_item\r\n" + 
				"   SET status = :status,\r\n" + 
				"    description = :description,\r\n" + 
				"    last_updated_timestamp = current_timestamp\r\n" + 
				"WHERE item_id = :itemId RETURNING item_id AS itemId;";
		
		public static final String DELETE_ITEM_SQL = "DELETE FROM public.todo_item WHERE item_id = :itemId "
				+ "RETURNING item_id AS itemId;";
		
		public static final String GET_LIST_SQL = "SELECT list.list_id AS listId,\r\n" + 
				"    list.category AS category,\r\n" + 
				"    list.description AS listDescription,\r\n" + 
				"    list.created_timestamp AS listCreatedTimestamp,\r\n" + 
				"    list.last_updated_timestamp AS listLastUpdatedTimestamp,\r\n" + 
				"    item.item_id AS itemId,\r\n" + 
				"    item.status AS status,\r\n" + 
				"    item.description AS itemDescription,\r\n" + 
				"    item.created_timestamp AS itemCreatedTimestamp,\r\n" + 
				"    item.last_updated_timestamp AS itemLastUpdatedTimestamp\r\n" + 
				"  FROM  public.todo_list list\r\n" + 
				"  JOIN  public.todo_item item\r\n" + 
				"ON list.list_id = item.list_id;";
}

// CSSE 132 Lab 5: simple.c
// Names: Oyenbhen Omotese




#include "data.h"
#include "stdlib.h"

void main()
{
	 struct db_entry stack;
	 struct db_entry* heap = malloc(sizeof(struct db_entry));

	 stack.name = "Joy";
	 stack.value = "1";

	 dbe_print(&stack);
	 
	 
	 heap -> name = "Hello";
	 heap -> value = "2";

	 dbe_print(heap); //heap is an address, not an instance
	 free(heap);
	 
	 struct db_entry* data = dbe_alloc("My Name", "My Value");
	 dbe_print(data);
	 dbe_free(data);
}

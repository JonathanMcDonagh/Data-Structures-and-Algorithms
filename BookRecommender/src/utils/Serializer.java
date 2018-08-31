//Author - Jonathan McDonagh / June 2018
package utils;

public interface Serializer {
	  void push(Object o);
	  Object pop();
	  void write() throws Exception;
	  void read() throws Exception;
}

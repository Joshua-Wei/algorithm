package string;

import java.util.*;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * 
 * Corner Cases:
 * - Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * @author Joshua Wei
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
        if (path == null || path.length() == 0) return path;
        
        String[] dirs = path.split("/");
        
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < dirs.length; i++) {
            if (dirs[i].length() == 0 || dirs[i].equals(".")) {
            	continue;
            } else if (dirs[i].equals("..")) {
            	if (!stack.isEmpty()) stack.pop();
            } else {
            	stack.push(dirs[i]);
            }
        }
        
        String ret = "";
        while (!stack.isEmpty()) {
        	if (ret.length() > 0) ret = "/" + ret;
            ret = stack.pop() + ret;
        }
        ret = "/" + ret;
        return ret;
    }
}

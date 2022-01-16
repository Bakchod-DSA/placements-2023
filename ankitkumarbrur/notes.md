> # C++
## 1. What is the difference in NULL and nullptr
* The macro `NULL` is an implementation-defined null pointer constant, which may be
    - an integral constant expression rvalue of integer type that evaluates to `zero`. (until C++11) <br/>
    - an integer literal with value zero, or a prvalue of type `std::nullptr_t`. (since C++11)<br/>
    <br/>
    
    A null pointer constant may be implicitly converted to any pointer and pointer to member type; such conversion results in the null pointer value of that type. If a null pointer constant has integer type, it may be converted to a prvalue of type `std::nullptr_t`.
    <br/>

    **possibly:**
    ```c++
    #define NULL 0
    //since C++11
    #define NULL nullptr
    ```

* **nullptr** denotes the pointer literal. It is a `prvalue` of type `std::nullptr_t`, it can convert into a pointer, but not into integers. There exist implicit conversions from nullptr to null pointer value of any pointer type and any pointer to member type. Similar conversions exist for any null pointer constant, which includes values of type `std::nullptr_t` as well as the macro `NULL`.

    ***Example:***
    ```c++
    #include <cstddef>
    #include <iostream>

    void f(int*) {
        std::cout << "Pointer to integer overload\n";
    }

    void f(double*) {
        std::cout << "Pointer to double overload\n";
    }

    void f(std::nullptr_t) {
        std::cout << "null pointer overload\n";
    }

    int main() {
        int* pi {}; double* pd {};

        f(pi);
        f(pd);
        f(nullptr); // would be ambiguous without void f(nullptr_t)
        // f(0);    // ambiguous call: all three functions are candidates
        // f(NULL); // ambiguous if NULL is an integral null pointer constant 
                    // (as is the case in most implementations)
    }
    ```
    ***Output:***
    ```
    Pointer to integer overload
    Pointer to double overload
    null pointer overload
    ```

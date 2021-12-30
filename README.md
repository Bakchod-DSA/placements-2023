# **SDE Placement Prepration**

Placement preparation session 2022

<br/>

> ## **Contribution**

<br/>

1. ### _Commit Style_

   - Please read: [How to write a git commit message](https://chris.beams.io/posts/git-commit/).

   - If you are adding any solution to a problem follow this style:

     ```git
     github_username: <commit_message>
     Example: ankitkumarbrur: add leetcode solution 222
     ```

   - Use template to specify commit format. [Here is how.](https://gist.github.com/lisawolderiksen/a7b99d94c92c6671181611be1641c733)

   - You can use code editor other then _vi_ to write commit message. Click [here](https://git-scm.com/book/en/v2/Appendix-C%3A-Git-Commands-Setup-and-Config) to know more.

<br/>

2. ### _Code Header_

   ```cpp
   // @author: author_name
   // @user: user_name
   // Link to the question/resource

   /*
   * Code
   */
   ```

   **Note**: If you are using vscode you can define a custom snippet for the language in which you solve the problems:

   ```json
   "add header": {
       "prefix": "header",
       "body": [
           "// @author: <author_name>",
           "// @user: <user_name>",
           "// Link: $1"
       ]
   }
   ```

   Replace `<author_name>` and `<user_name>` as per yours.

<br/>

---

> ## If you use VScode

<br/>

- ### Code Formatter

  - [clang-format](https://marketplace.visualstudio.com/items?itemName=xaver.clang-format)
  
    <br/>

- ### For leetcode problems use this extension:

  - [vscode](https://marketplace.visualstudio.com/items?itemName=LeetCode.vscode-leetcode)

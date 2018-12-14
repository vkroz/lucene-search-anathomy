# Welcome to MkDocs

For full documentation visit [https://www.mkdocs.org/user-guide/writing-your-docs/]()

## Commands

- `mkdocs new [dir-name]` - Create a new project.
- `mkdocs serve` - Start docs server with live-reloading.
- `mkdocs build` - Build the documentation site.
- `mkdocs gh-deploy` - Deploy documentation site to git-pages on github 
- `mkdocs help` - Print this help message.

Project layout

```
mkdocs.yml    # The configuration file.
docs/
    index.md  # The documentation homepage.
    ...       # Other markdown pages, images and other files.
```

## Formatting elements

### CodeHilite

```python
import tensorflow as tf
```


#### Shebang

Alternatively, if the first line of a code block contains a shebang, the language is derived from the path referenced in the shebang. This will only work for code blocks that are indented using four spaces, not for those encapsulated in three backticks.

Example:

    #!/usr/bin/python
    import tensorflow as tf


### Grouping code blocks




!!! note
    ~~~Bash tab=
    #!/bin/bash
    STR="Hello World!"
    echo $STR
    ~~~

    ~~~C tab=
    #include 
    int main(void) {
      printf("hello, world\n");
    }
    ~~~

    
### Admonitions

> :memo: **Title**



> :blue_book: **Note: Cool Feature**
> Information here


!!! quote
    > :memo:{.tip} **The Tip Title**
    The content


!!! quote
    Lorem :mega: ipsum dolor sit amet, consectetur adipiscing elit. Nulla et euismod
    nulla. Curabitur feugiat, tortor non consequat finibus, justo purus auctor
    massa, :blue_book: **Note: Cool Feature** nec semper lorem quam in massa.

!!! note
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla et euismod
    nulla. Curabitur feugiat, tortor non consequat finibus, justo purus auctor
    massa, nec semper lorem quam in massa.


!!! note "Phasellus posuere in sem ut cursus"
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla et euismod
    nulla. Curabitur feugiat, tortor non consequat finibus, justo purus auctor
    massa, nec semper lorem quam in massa.
    
    
    
!!! tip
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla et euismod
    nulla. Curabitur feugiat, tortor non consequat finibus, justo purus auctor
    massa, nec semper lorem quam in massa.
    
!!! help
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla et euismod
    nulla. Curabitur feugiat, tortor non consequat finibus, justo purus auctor
    massa, nec semper lorem quam in massa.
    
!!! faq
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla et euismod
    nulla. Curabitur feugiat, tortor non consequat finibus, justo purus auctor
    massa, nec semper lorem quam in massa.
    
    

<template>
    <header>
        <nav>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Clietntes</a>
                    <ul>
                        <li><a href="#">Cadastrar</a></li>
                        <li><a href="#">Alterar</a></li>
                        <li><a href="#">Remover</a></li>
                    </ul>
                </li>
                <li><a href="#">Exemplares</a>
                    <ul>
                        <li><a href="#">Cadastrar</a></li>
                        <li><a href="#">Alterar</a></li>
                        <li><a href="#">Remover</a></li>
                    </ul>
                </li>
                <li><a href="#">Categorias de Exemplares</a>
                    <ul>
                        <li><a href="#">Cadastrar</a></li>
                        <li><a href="#">Alterar</a></li>
                        <li><a href="#">Remover</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </header>
</template>


<script>
export default {
    name : "MainHeader"
}
</script>

<style scoped>
    @import url('https://fonts.googleapis.com/css2?family=Montserrat:wght@100&display=swap');

    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
        font-size: 18px;
        font-family:  'sans-serif';
    }

    header{
        background-color: #333;
        overflow: hidden;
        display: flex;
    }

    header ul li a{
        color: #f2f2f2;
        text-align: center;
        padding:14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    header ul li:hover{
        background-color: #ddd;
        color: black;
    }

    header ul li a.active{
        background-color: #04AA6D;
        color: white;
    }

    header ul ul{
        margin-left: 201px;
        top: 0px;
        position: relative;
    }

    @media screen and (max-width: 768px) {
        header {
            flex-direction: column;
        }
    }

</style>
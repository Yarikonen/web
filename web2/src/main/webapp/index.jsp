<jsp:useBean id="table" scope="session" class="model.Table"/>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <title>Second Lab WEB</title>
    <meta name="author" content="Yaroslav">
    <meta name="description" content="best lab or whatever">
    <link rel="stylesheet" type="text/css" href="style2.css"/>

</head>

<body>
<div id ="header">
    <h1 ><text id ="W"></text>Web 2</h1>
    <p class="author"> Рудык Ярослав P32111 Вариант 1016</p>
</div>



<div id="left" class="main">
    <b>Разработанная HTML-страница должна удовлетворять следующим требованиям:</b> <br>
    <ul>
        <li>Для расположения текстовых и графических элементов необходимо использовать блочную верстку.    </li>
        <li>Данные формы должны передаваться на обработку посредством GET-запроса.</li>
        <li>Таблицы стилей должны располагаться в самом веб-документе.   </li>
        <li>При работе с CSS должно быть продемонстрировано использование селекторов идентификаторов, селекторов классов, селекторов потомств, селекторов псевдоэлементов а также такие свойства стилей CSS, как наследование и каскадирование.</li>
        <li>HTML-страница должна иметь "шапку", содержащую ФИО студента, номер группы и новер варианта. При оформлении шапки необходимо явным образом задать шрифт (fantasy), его цвет и размер в каскадной таблице стилей.    </li>
        <li>Отступы элементов ввода должны задаваться в процентах.</li>
        <li>Страница должна содержать сценарий на языке JavaScript, осуществляющий валидацию значений, вводимых пользователем в поля формы. Любые некорректные значения (например, буквы в координатах точки или отрицательный радиус) должны блокироваться.
        </li>
    </ul>

</div>
<div id="center"  class = "main">
    <div id="image1">
        <svg width="649" height="591" viewBox="0 0 649 591" fill="none" xmlns="http://www.w3.org/2000/svg">
            <rect width="649" height="591" fill="#141414"/>
            <line x1="324.5" y1="41" x2="324.5" y2="591" stroke="#747474"/>
            <line y1="295.5" x2="600" y2="295.5" stroke="#747474"/>
            <path d="M336.057 433V424.273H339.006C339.688 424.273 340.247 424.389 340.685 424.622C341.122 424.852 341.446 425.169 341.656 425.572C341.866 425.976 341.972 426.435 341.972 426.949C341.972 427.463 341.866 427.919 341.656 428.317C341.446 428.714 341.124 429.027 340.689 429.254C340.254 429.479 339.699 429.591 339.023 429.591H336.636V428.636H338.989C339.455 428.636 339.83 428.568 340.114 428.432C340.401 428.295 340.608 428.102 340.736 427.852C340.866 427.599 340.932 427.298 340.932 426.949C340.932 426.599 340.866 426.294 340.736 426.033C340.605 425.771 340.396 425.57 340.109 425.428C339.822 425.283 339.443 425.21 338.972 425.21H337.114V433H336.057ZM340.165 429.08L342.312 433H341.085L338.972 429.08H340.165ZM346.681 423.864L343.869 434.312H342.949L345.761 423.864H346.681ZM347.857 433V432.233L350.737 429.08C351.075 428.71 351.354 428.389 351.572 428.116C351.791 427.841 351.953 427.582 352.058 427.341C352.166 427.097 352.22 426.841 352.22 426.574C352.22 426.267 352.146 426.001 351.999 425.777C351.854 425.553 351.655 425.379 351.402 425.257C351.149 425.135 350.865 425.074 350.55 425.074C350.214 425.074 349.922 425.143 349.672 425.283C349.425 425.419 349.233 425.611 349.097 425.858C348.963 426.105 348.896 426.395 348.896 426.727H347.891C347.891 426.216 348.009 425.767 348.244 425.381C348.48 424.994 348.801 424.693 349.207 424.477C349.616 424.261 350.075 424.153 350.584 424.153C351.095 424.153 351.548 424.261 351.943 424.477C352.338 424.693 352.648 424.984 352.872 425.351C353.097 425.717 353.209 426.125 353.209 426.574C353.209 426.895 353.151 427.209 353.034 427.516C352.92 427.82 352.722 428.159 352.438 428.534C352.156 428.906 351.766 429.361 351.266 429.898L349.305 431.994V432.062H353.362V433H347.857Z" fill="white"/>
            <path d="M336.057 184V175.273H339.006C339.688 175.273 340.247 175.389 340.685 175.622C341.122 175.852 341.446 176.169 341.656 176.572C341.866 176.976 341.972 177.435 341.972 177.949C341.972 178.463 341.866 178.919 341.656 179.317C341.446 179.714 341.124 180.027 340.689 180.254C340.254 180.479 339.699 180.591 339.023 180.591H336.636V179.636H338.989C339.455 179.636 339.83 179.568 340.114 179.432C340.401 179.295 340.608 179.102 340.736 178.852C340.866 178.599 340.932 178.298 340.932 177.949C340.932 177.599 340.866 177.294 340.736 177.033C340.605 176.771 340.396 176.57 340.109 176.428C339.822 176.283 339.443 176.21 338.972 176.21H337.114V184H336.057ZM340.165 180.08L342.312 184H341.085L338.972 180.08H340.165ZM346.681 174.864L343.869 185.312H342.949L345.761 174.864H346.681ZM347.857 184V183.233L350.737 180.08C351.075 179.71 351.354 179.389 351.572 179.116C351.791 178.841 351.953 178.582 352.058 178.341C352.166 178.097 352.22 177.841 352.22 177.574C352.22 177.267 352.146 177.001 351.999 176.777C351.854 176.553 351.655 176.379 351.402 176.257C351.149 176.135 350.865 176.074 350.55 176.074C350.214 176.074 349.922 176.143 349.672 176.283C349.425 176.419 349.233 176.611 349.097 176.858C348.963 177.105 348.896 177.395 348.896 177.727H347.891C347.891 177.216 348.009 176.767 348.244 176.381C348.48 175.994 348.801 175.693 349.207 175.477C349.616 175.261 350.075 175.153 350.584 175.153C351.095 175.153 351.548 175.261 351.943 175.477C352.338 175.693 352.648 175.984 352.872 176.351C353.097 176.717 353.209 177.125 353.209 177.574C353.209 177.895 353.151 178.209 353.034 178.516C352.92 178.82 352.722 179.159 352.438 179.534C352.156 179.906 351.766 180.361 351.266 180.898L349.305 182.994V183.062H353.362V184H347.857Z" fill="white"/>
            <path d="M449.057 320V311.273H452.006C452.688 311.273 453.247 311.389 453.685 311.622C454.122 311.852 454.446 312.169 454.656 312.572C454.866 312.976 454.972 313.435 454.972 313.949C454.972 314.463 454.866 314.919 454.656 315.317C454.446 315.714 454.124 316.027 453.689 316.254C453.254 316.479 452.699 316.591 452.023 316.591H449.636V315.636H451.989C452.455 315.636 452.83 315.568 453.114 315.432C453.401 315.295 453.608 315.102 453.736 314.852C453.866 314.599 453.932 314.298 453.932 313.949C453.932 313.599 453.866 313.294 453.736 313.033C453.605 312.771 453.396 312.57 453.109 312.428C452.822 312.283 452.443 312.21 451.972 312.21H450.114V320H449.057ZM453.165 316.08L455.312 320H454.085L451.972 316.08H453.165ZM459.681 310.864L456.869 321.312H455.949L458.761 310.864H459.681ZM460.857 320V319.233L463.737 316.08C464.075 315.71 464.354 315.389 464.572 315.116C464.791 314.841 464.953 314.582 465.058 314.341C465.166 314.097 465.22 313.841 465.22 313.574C465.22 313.267 465.146 313.001 464.999 312.777C464.854 312.553 464.655 312.379 464.402 312.257C464.149 312.135 463.865 312.074 463.55 312.074C463.214 312.074 462.922 312.143 462.672 312.283C462.425 312.419 462.233 312.611 462.097 312.858C461.963 313.105 461.896 313.395 461.896 313.727H460.891C460.891 313.216 461.009 312.767 461.244 312.381C461.48 311.994 461.801 311.693 462.207 311.477C462.616 311.261 463.075 311.153 463.584 311.153C464.095 311.153 464.548 311.261 464.943 311.477C465.338 311.693 465.648 311.984 465.872 312.351C466.097 312.717 466.209 313.125 466.209 313.574C466.209 313.895 466.151 314.209 466.034 314.516C465.92 314.82 465.722 315.159 465.438 315.534C465.156 315.906 464.766 316.361 464.266 316.898L462.305 318.994V319.062H466.362V320H460.857Z" fill="white"/>
            <path d="M214.057 320V311.273H217.006C217.688 311.273 218.247 311.389 218.685 311.622C219.122 311.852 219.446 312.169 219.656 312.572C219.866 312.976 219.972 313.435 219.972 313.949C219.972 314.463 219.866 314.919 219.656 315.317C219.446 315.714 219.124 316.027 218.689 316.254C218.254 316.479 217.699 316.591 217.023 316.591H214.636V315.636H216.989C217.455 315.636 217.83 315.568 218.114 315.432C218.401 315.295 218.608 315.102 218.736 314.852C218.866 314.599 218.932 314.298 218.932 313.949C218.932 313.599 218.866 313.294 218.736 313.033C218.605 312.771 218.396 312.57 218.109 312.428C217.822 312.283 217.443 312.21 216.972 312.21H215.114V320H214.057ZM218.165 316.08L220.312 320H219.085L216.972 316.08H218.165ZM224.681 310.864L221.869 321.312H220.949L223.761 310.864H224.681ZM225.857 320V319.233L228.737 316.08C229.075 315.71 229.354 315.389 229.572 315.116C229.791 314.841 229.953 314.582 230.058 314.341C230.166 314.097 230.22 313.841 230.22 313.574C230.22 313.267 230.146 313.001 229.999 312.777C229.854 312.553 229.655 312.379 229.402 312.257C229.149 312.135 228.865 312.074 228.55 312.074C228.214 312.074 227.922 312.143 227.672 312.283C227.425 312.419 227.233 312.611 227.097 312.858C226.963 313.105 226.896 313.395 226.896 313.727H225.891C225.891 313.216 226.009 312.767 226.244 312.381C226.48 311.994 226.801 311.693 227.207 311.477C227.616 311.261 228.075 311.153 228.584 311.153C229.095 311.153 229.548 311.261 229.943 311.477C230.338 311.693 230.648 311.984 230.872 312.351C231.097 312.717 231.209 313.125 231.209 313.574C231.209 313.895 231.151 314.209 231.034 314.516C230.92 314.82 230.722 315.159 230.438 315.534C230.156 315.906 229.766 316.361 229.266 316.898L227.305 318.994V319.062H231.362V320H225.857Z" fill="white"/>
            <path d="M336.057 557V548.273H339.006C339.688 548.273 340.247 548.389 340.685 548.622C341.122 548.852 341.446 549.169 341.656 549.572C341.866 549.976 341.972 550.435 341.972 550.949C341.972 551.463 341.866 551.919 341.656 552.317C341.446 552.714 341.124 553.027 340.689 553.254C340.254 553.479 339.699 553.591 339.023 553.591H336.636V552.636H338.989C339.455 552.636 339.83 552.568 340.114 552.432C340.401 552.295 340.608 552.102 340.736 551.852C340.866 551.599 340.932 551.298 340.932 550.949C340.932 550.599 340.866 550.294 340.736 550.033C340.605 549.771 340.396 549.57 340.109 549.428C339.822 549.283 339.443 549.21 338.972 549.21H337.114V557H336.057ZM340.165 553.08L342.312 557H341.085L338.972 553.08H340.165Z" fill="white"/>
            <path d="M336.057 60V51.2727H339.006C339.688 51.2727 340.247 51.3892 340.685 51.6222C341.122 51.8523 341.446 52.169 341.656 52.5724C341.866 52.9759 341.972 53.4347 341.972 53.9489C341.972 54.4631 341.866 54.919 341.656 55.3168C341.446 55.7145 341.124 56.027 340.689 56.2543C340.254 56.4787 339.699 56.5909 339.023 56.5909H336.636V55.6364H338.989C339.455 55.6364 339.83 55.5682 340.114 55.4318C340.401 55.2955 340.608 55.1023 340.736 54.8523C340.866 54.5994 340.932 54.2983 340.932 53.9489C340.932 53.5994 340.866 53.294 340.736 53.0327C340.605 52.7713 340.396 52.5696 340.109 52.4276C339.822 52.2827 339.443 52.2102 338.972 52.2102H337.114V60H336.057ZM340.165 56.0795L342.312 60H341.085L338.972 56.0795H340.165Z" fill="white"/>
            <path d="M574.057 320V311.273H577.006C577.688 311.273 578.247 311.389 578.685 311.622C579.122 311.852 579.446 312.169 579.656 312.572C579.866 312.976 579.972 313.435 579.972 313.949C579.972 314.463 579.866 314.919 579.656 315.317C579.446 315.714 579.124 316.027 578.689 316.254C578.254 316.479 577.699 316.591 577.023 316.591H574.636V315.636H576.989C577.455 315.636 577.83 315.568 578.114 315.432C578.401 315.295 578.608 315.102 578.736 314.852C578.866 314.599 578.932 314.298 578.932 313.949C578.932 313.599 578.866 313.294 578.736 313.033C578.605 312.771 578.396 312.57 578.109 312.428C577.822 312.283 577.443 312.21 576.972 312.21H575.114V320H574.057ZM578.165 316.08L580.312 320H579.085L576.972 316.08H578.165Z" fill="white"/>
            <path d="M103.057 320V311.273H106.006C106.688 311.273 107.247 311.389 107.685 311.622C108.122 311.852 108.446 312.169 108.656 312.572C108.866 312.976 108.972 313.435 108.972 313.949C108.972 314.463 108.866 314.919 108.656 315.317C108.446 315.714 108.124 316.027 107.689 316.254C107.254 316.479 106.699 316.591 106.023 316.591H103.636V315.636H105.989C106.455 315.636 106.83 315.568 107.114 315.432C107.401 315.295 107.608 315.102 107.736 314.852C107.866 314.599 107.932 314.298 107.932 313.949C107.932 313.599 107.866 313.294 107.736 313.033C107.605 312.771 107.396 312.57 107.109 312.428C106.822 312.283 106.443 312.21 105.972 312.21H104.114V320H103.057ZM107.165 316.08L109.312 320H108.085L105.972 316.08H107.165Z" fill="white"/>
            <path d="M449 296C449 365.036 393.483 421 325 421" stroke="#0C8CE9"/>
            <path d="M324.854 0.646447C324.658 0.451184 324.342 0.451184 324.146 0.646447L320.964 3.82843C320.769 4.02369 320.769 4.34027 320.964 4.53553C321.16 4.7308 321.476 4.7308 321.672 4.53553L324.5 1.70711L327.328 4.53553C327.524 4.7308 327.84 4.7308 328.036 4.53553C328.231 4.34027 328.231 4.02369 328.036 3.82843L324.854 0.646447ZM325 41V1H324V41H325Z" fill="#747474"/>
            <path d="M648.354 295.854C648.549 295.658 648.549 295.342 648.354 295.146L645.172 291.964C644.976 291.769 644.66 291.769 644.464 291.964C644.269 292.16 644.269 292.476 644.464 292.672L647.293 295.5L644.464 298.328C644.269 298.524 644.269 298.84 644.464 299.036C644.66 299.231 644.976 299.231 645.172 299.036L648.354 295.854ZM600 296H648V295H600V296Z" fill="#747474"/>
            <path d="M449 296V48H325V296" stroke="#0C8CE9"/>
            <line x1="323.897" y1="545.146" x2="75.5362" y2="296.785" stroke="#0C8CE9"/>
            <line x1="77" y1="295.5" x2="325" y2="295.5" stroke="#0C8CE9"/>
            <line x1="324.5" y1="546" x2="324.5" y2="420" stroke="#0C8CE9"/>

        </svg>
    </div>
    <script>

    </script>
    <form action="" onsubmit="onSubmit(); return false;">
        <div id ="x">
            <label>Значение X:</label>
            <input type="radio" id = x_v1 name="x_v" value="-2.0" checked>
            <label for="x_v1">-2</label>
            <input type="radio" id="x_v2" name = "x_v" value="-1.5">
            <label for="x_v2">-1.5</label>
            <input type="radio" id="x_v3" name = "x_v" value="-1">
            <label for="x_v3">-1</label>
            <input type="radio" id="x_v4" name = "x_v" value="-0.5">
            <label for="x_v4">-0.5</label>
            <input type="radio" id="x_v5" name = "x_v" value="0.0">
            <label for="x_v5">0</label>
            <input type="radio" id="x_v6" name = "x_v" value="0.5">
            <label for="x_v6">0.5</label>
            <input type="radio" id="x_v7" name = "x_v" value="1">
            <label for="x_v7">1</label>
            <input type="radio" id="x_v8" name = "x_v" value="1.5">
            <label for="x_v8">1.5</label>
            <input type="radio" id="x_v9" name = "x_v" value="2">
            <label for="x_v9">2</label>
        </div>
        <div id ="r">
            <label>Значение R:</label>
            <input type="radio" id = r_v1 name="r_v" value="1.0" checked>
            <label for="r_v1">1</label>
            <input type="radio" id="r_v2" name = "r_v" value="1.5">
            <label for="r_v2">1.5</label>
            <input type="radio" id="r_v3" name = "r_v" value="2.0">
            <label for="r_v3">2</label>
            <input type="radio" id="r_v4" name = "r_v" value="2.5">
            <label for="r_v4">2.5</label>
            <input type="radio" id="r_v5" name = "r_v" value="3.0">
            <label for="r_v5">3</label>

        </div>
        <div id="y">
            <label>Значение Y:</label>
            <input type="text" placeholder="-5 ... 5" id="y_v" maxlength="10">
        </div>
        <div id="btndiv"><input type="submit" class="btn"></div>

    </form>


</div>
<div id="right" class = "main" >
    <table id ="table" >
       ${table.saveTable()}


    </table>
</div>
<script src="btnListener2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="svgConnector1.js">  </script>




</body>
</html>

<b> Challenge: Reassemble Text Fragments </b>

<h4> Background </h4>

Imagine you have 5 copies of the same page of text. You value this text and have no hard or soft
copies of it. Your two year old nephew visits and, while you are not looking, rips each page up into
fragments and gleefully plays in the “snow” he has just created.

You need at least one copy of that page of text back ASAP. As punishment to your niece, who should
have been supervising your nephew at the time of the incident, you set her the painstaking task of
keying in all the paper text fragments to a text file on your shiny MacBook Pro. Now the task is
yours. Can you reassemble a soft copy of the original document?

<h4> The Challenge </h4>

Write a program to reassemble a given set of text fragments into their original sequence. For this
challenge your program should have a main method accepting one argument – the path to a wellformed UTF-8 encoded text file. Each line in the file represents a test case of the main functionality
of your program: read it, process it and println to the console the corresponding defragmented
output.
Each line contains text fragments separated by a semicolon, ‘;’. You can assume that every fragment
has length at least 2.

<h4> Example input 1: </h4>
O draconia;conian devil! Oh la;h lame sa;saint!
<br>
<h4> Example output 1: </h4>
O draconian devil! Oh lame saint!

<h4> Example input 2: </h4>
m quaerat voluptatem.;pora incidunt ut labore et d;, consectetur, adipisci velit;olore magnam
aliqua;idunt ut labore et dolore magn;uptatem.;i dolorem ipsum qu;iquam quaerat vol;psum quia
dolor sit amet, consectetur, a;ia dolor sit amet, conse;squam est, qui do;Neque porro quisquam est,
qu;aerat voluptatem.;m eius modi tem;Neque porro qui;, sed quia non numquam ei;lorem ipsum
quia dolor sit amet;ctetur, adipisci velit, sed quia non numq;unt ut labore et dolore magnam aliquam
qu;dipisci velit, sed quia non numqua;us modi tempora incid;Neque porro quisquam est, qui
dolorem i;uam eius modi tem;pora inc;am al
<br>
<h4>Example output 2:</h4>
Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed
quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat
voluptatem.

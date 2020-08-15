



[![Build Status](https://travis-ci.org/AbdullahTaher93/TFM.svg?branch=master)](https://travis-ci.org/AbdullahTaher93/TFM) [![Language](https://img.shields.io/badge/laguage-java-green.svg)](https://www.java.com/)

# Cryptanalysis Ciphertext Based Genetic Algorithms

## ABSTRACT  
Cryptanalysis is breaking the ciphertext(codes) to find the
plaintext (original text) .There are many tools used in the cryptanalysis.Genetic algorithm(GA).Is an optimization search
tool to find the best solution.In this project ,Genetic algorithm(GA) used as a cryptanalysis tool to search the decryption key for obtaining the plaintext from the ciphertext.When the ciphertext generated by the transpositioncipher.

## Introduction
Cryptanalysis is the technique of deriving the original message from the cipher text without any prior knowledge of secret key or the erivation of key from the cipher text. A general technique for cryptanalysis, applied to all cryptographic algos is to try all the possible keys until the correct key is matched, it is known as exhaustive key search. 

A symmetric key cipher, especially a stream cipher is assumed secure, if the computational capability required for breaking the cipher by best-known attack is greater than or equal to exhaustive key search. 
Cryptanalysis is the science of making encrypted data unencrypted use convert cipher text to plaintext because cryptanalysis used to convert plaintext to cipher text and used cryptanalysis Return to plaintext or clear text or original text cryptanalysis is used to break codes by finding weaknesses. There are many techniques used in the cryptanalysis. This project used the genetics algorithm.

The genetic algorithm is a search algorithm based on the mechanics of natural selection and natural genetics The genetic algorithm belongs to the family of evolutionary algorithms, along with genetic programming, Evolution strategies and evolutionary programming. The set of operators usually consists of mutation, crossover and selection,

Cryptanalysis is the technique of extracting useful information about the key by observing the plaintext and cipher text using cryptanalysis   try to break the secrecy provided by the cipher. There is no fixed method for cryptanalysis and every cipher is a different challenge to the attacker and hence demands different insight to attack  In this chapter, explained the history of cryptanalysis, the technology of cryptanalysis, transposition cipher, and description genetics algorithm (GA).

## Cryptanalysis
Cryptanalysis are the basic techniques on block cipher and till today, many cryptanalytic attacks are developed based on these. The cryptanalysis return cipher text to clear text  (or original text) by different methods to find the decryption  key, in other words, cryptanalysis is a method to reveal the key by the Receiver to transform cipher text to plaintext (or original text)

![Cryptanalysis](https://github.com/AbdullahTaher93/TFM/blob/master/images/Cryptanalysis.png)

## Implementation

genetic algorithm (GA) can be used for  obtaining  the decryption key to break ciphertext and transfer ciphertext message to plaintext message (readable message). GA is a search tool to insure high probability of finding a solution by decreasing the amount of time in the key space searching. GA consists of many operations: Evaluation fitness, Selection, Crossover, and Mutation. In Figure below Flowchart of proposed method of cryptanalysis.

![Flowchart](https://github.com/AbdullahTaher93/TFM/blob/master/images/Flowchart.png)


### 1- Initialization (Population)
Population is a subset of solutions in the current generation. It can also be defined as a set of chromosomes. There are several things to be kept in mind when dealing with GA population −

* The diversity of the population should be maintained otherwise it might lead to premature convergence.

* The population size should not be kept very large as it can cause a GA to slow down, while a smaller population might not be enough for a good mating pool. Therefore, an optimal population size needs to be decided by trial and error.

The population is usually defined as a two dimensional array of – size population, size  x , chromosome size.

There are two primary methods to initialize a population in a GA. They are −

* Random Initialization − Populate the initial population with completely random solutions.

* Heuristic initialization − Populate the initial population using a known heuristic for the problem

So with our problem we will use the first method which is (Random Initialization) generate a pool of random keys (size population), when the length of the key is N digits (chromosome size)  and the pool size is M keys(size population). Also, The key condition is random and non-repetitive in each key. These keys are changeable  by the other stages of GA and the better one used in derivation the plaintext.

### 2- Transposition Cipher
The transposition cipher is rearranged (change position only) the characters in the message but not change the characters. Transposition cipher have a pool of keys and ciphertext  that rearranged the ciphertext  for M times depended on the pool of keys. The output of transposition cipher saved in array of M locations we can called it  "plaintext_array".

A simple transposition or permutation cipher works by breaking a message into fixed size blocks, and then permuting the characters within each block according to a fixed permutation, say P. The key to the transposition cipher is simply the permutation P. So, the transposition cipher has the property that the encrypted message contains all the characters that were in the plaintext message. In other words, the unigram statistics for the message are unchanged by the encryption process. The size of the permutation is known as the period. Let's consider an example of a transposition cipher with a period of ten 10, and a key P={7,10,4,2,8,1,5,9,6,3}. In this case, the message is broken into blocks of ten characters, and after encryption the seventh character in the block will be moved to position 1, the tenth moved character in the block will be moved to position 2, the forth is moved to position 3, the second to position 4, the eighth to position 5, the first to position 6, the fifth to the position 7, the ninth to the position 8, the sixth to the position 9 and the third to position 10.

In  Table below shows the key and the encryption process of the previously described transposition cipher. It can be noticed that the random string "X" was appended to the end of the message to enforce a message length, which is a
multiple of the block size.It is also clear that thedecryption can be achieved by following the same process as encryption using the "inverse" of the encryption permutation. In this case the decryption key, P-1 is equal to {6,4,10,3,7,9,1,5, 8,2}. 

![Transposition](https://github.com/AbdullahTaher93/TFM/blob/master/images/Transposition.png)

### 3- Evaluation Fitness 
Fitness is evaluated based on the biagrams (sequence of two letters) frequency in the decrypted cipher text and Trigrams (sequence of three letters) frequency in the decrypted cipher text. the tables below illustrated the most popular biagrams and Trigrams  in English language. Triagrams and diagrams   are   computationally expensive the fitness calculation.  Fitness function is as shown below equation:

     Fitness function= β. ∑| (K (bi, j) −D (bi, j))|+   γ. ∑| (K (ti, j) −D (ti, j))|

Where β and γ are a constant
* K represents Known English Language
* D represents Decrypted the message
* Bi represents the bigram (two letter sequence).
* Ti represents the triagram (three letter sequence).

![TiBi1](https://github.com/AbdullahTaher93/TFM/blob/master/images/TIBI1.png)

![TiBi2](https://github.com/AbdullahTaher93/TFM/blob/master/images/TIBI2.png)


### 4- Selection operation
In this operation, selection (choosing) the best keys only. The best key which has the high value of fitness. In the proposed work select only M/2 keys which have the high fitness.  To perform the selection operation nedded a sorting function to sort pool of keys from high fitness to low fitness.Fitness Proportionate Selection is one of the most popular ways of parent selection. In this every individual can become a parent with a probability which is proportional to its fitness. Therefore, fitter individuals have a higher chance of mating and propagating their features to the next generation. Therefore, such a selection strategy applies a selection pressure to the more fit individuals in the population, evolving better individuals over time.




### 5- Crossover Operation
In this operation, after selecting the best M/2 keys by the selection operation, applying the crossover operation to obtain the remainder M/2 keys. In the crossover operation, each key performs a crossover to obtain a new key with the condition non-primitive keys. After the crossover operation, a new pool of keys obtaining, these are called "new population".

#### 5.1 One Point Crossover
In this one-point crossover, a random crossover point is selected and the tails of its two parents are swapped to get new off-springs.

![one_point_crossover](https://github.com/AbdullahTaher93/TFM/blob/master/images/one_point_crossover.png)

#### 5.2 Multi Point Crossover
Multi point crossover is a generalization of the one-point crossover wherein alternating segments are swapped to get new off-springs.

![multi_point_crossover](https://github.com/AbdullahTaher93/TFM/blob/master/images/multi_point_crossover.png)

#### 5.3 Uniform Crossover
In a uniform crossover, we don’t divide the chromosome into segments, rather we treat each gene separately. In this, we essentially flip a coin for each chromosome to decide whether or not it’ll be included in the off-spring. We can also bias the coin to one parent, to have more genetic material in the child from that parent.
![uniform_crossover](https://github.com/AbdullahTaher93/TFM/blob/master/images/uniform_crossover.png)

#### 5.4 Davis’ Order Crossover (OX1)
OX1 is used for permutation based crossovers with the intention of transmitting information about relative ordering to the off-springs. It works as follows −

Create two random crossover points in the parent and copy the segment between them from the first parent to the first offspring.

Now, starting from the second crossover point in the second parent, copy the remaining unused numbers from the second parent to the first child, wrapping around the list.

Repeat for the second child with the parent’s role reversed.

![david_order_crossover](https://github.com/AbdullahTaher93/TFM/blob/master/images/david_order_crossover.png)


### 6- Mutation Operation 
In this operation, applying the mutation operation for the new population.  To perform the mutation operation, two random numbers  generated  such as R1, and R2 representing  two positions in each key then swap between value of the position R1 and the value of the position R2.  Repeat this operation for all keys in the "new population" pool.

### 7- Display the Round No. and Plaintext
In this operation, display the plaintext (clear text is unencrypted information) for storage or transmission after decrypted the ciphertext. Also, display the Round number that obtaining the plaintext from ciphertext.

## Programming
### 1 Population Step
the first class to start is [Population.java](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/Population.java) in this class we created the Population which represents a set of chromosomes and each chromosome has the same length so, Population class has one constructor  and many methods that follow:

####  Population Constructor 
   Population(int No_OF_keys,int length_OF_key)
   * No_OF_keys: No. of chromosomes
   * length_OF_key: length of the chromosome
   under this Constructor, we can call all of the methods to create our population and show it.
   First method is [IF_KEY_EXIST](https://github.com/AbdullahTaher93/TFM/blob/5df7a0d35278b1491faf0b8c8891b0b6d2210aaf/Cryptanalysis_GAs/src/cryptanalysis_gas/Population.java#L24) this method will generates set of numbers between 1 and length of chromosome without repeat numbers (non-repetitive) and randomly, the method to ensure there are no duplicate number called [check](https://github.com/AbdullahTaher93/TFM/blob/5df7a0d35278b1491faf0b8c8891b0b6d2210aaf/Cryptanalysis_GAs/src/cryptanalysis_gas/Population.java#L41) which has to parameters array of numbers that saved before and new number which will save in same array, and return true or false (if this new number exist in array of number will return false in another case will return true and save it) after get more then 2 chromosomes we have to check if there are duplicate chromosomes this step done with this method which calls [check_row](https://github.com/AbdullahTaher93/TFM/blob/5df7a0d35278b1491faf0b8c8891b0b6d2210aaf/Cryptanalysis_GAs/src/cryptanalysis_gas/Population.java#L52) which receive all of chromosomes that saved before and new chromosome after that will compare between them to find if there are duplicated between these chromosomes, then will return false if there are no chromosomes duplicated and save it if not will repeat the step of creating new chromosome.

   finally, we can call [Print](https://github.com/AbdullahTaher93/TFM/blob/5df7a0d35278b1491faf0b8c8891b0b6d2210aaf/Cryptanalysis_GAs/src/cryptanalysis_gas/Population.java#L75) method to show all of the chromosomes

   ##### Experimental results
     No. of chromosomes is: 12
     length of chromosome is: 6 
     
   ![Chros12_6](https://github.com/AbdullahTaher93/TFM/blob/master/images/Chros12_6.png)

     No. of chromosomes is: 16
     length of chromosome is: 8

   ![Chros16_8](https://github.com/AbdullahTaher93/TFM/blob/master/images/Chros16_8.png)

### 2 Transposition Step

The second step is Transposition Cipher, in this class [Transposition.java](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/Transpostion.java) we will try to get the origin text by using exchange the positions of characters as I explained  in the section of Transposition Cipher, so if we have 16  keys, we can get 16 texts that  may be the plaintext,in this class, we have 4 methods and one constructor,

* [Transposition constructor](https://github.com/AbdullahTaher93/TFM/blob/5e216b8067cabc817ee4283c88210a251c72085c/src/cryptanalysis_gas/Transpostion.java#L12)
this Constructor has two parameters the array of keys which we got from Population class and ciphertext, then we will call methods that follow:

* [check_if_lenNotDivid](https://github.com/AbdullahTaher93/TFM/blob/5e216b8067cabc817ee4283c88210a251c72085c/src/cryptanalysis_gas/Transpostion.java#L30)
We created this method to enforce the message length, adding an "X" to the end of the message, making the message proportional to the key length.

* [change_position](https://github.com/AbdullahTaher93/TFM/blob/5e216b8067cabc817ee4283c88210a251c72085c/src/cryptanalysis_gas/Transpostion.java#L40)
this method splits the ciphertext as blocks, the length of each block equals the length of the key, then call the SortbyKey method with sending one of the keys and one of the blocks to exchange the characters positions in each block.

* [SortByKey](https://github.com/AbdullahTaher93/TFM/blob/5e216b8067cabc817ee4283c88210a251c72085c/src/cryptanalysis_gas/Transpostion.java#L62)
this method receives one of the keys and one block of ciphertext and then exchanges the positions of all characters in that block depending on that key.
* [Print](https://github.com/AbdullahTaher93/TFM/blob/5e216b8067cabc817ee4283c88210a251c72085c/src/cryptanalysis_gas/Transpostion.java#L75) this method called in the Transposition constructor to print the array of PlainText after doing the Transposition.

##### Experimental results

     No. of chromosomes is: 12
     length of chromosome is: 6
     CipherText: "epyrcntnoiXX"

   ![TransClass](https://github.com/AbdullahTaher93/TFM/blob/master/images/TransClass.png)

### 3 Evaluation Fitness step
with this step I created a new class, I called it, [Fitness.java](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java), this class contents on one constructor and set of methods to calculate fitness step by step, The first thing we did it is creating 4 arrays that follow:-
* [Twochar](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L24): to save the bigram frequencies.
* [TwoCharVale](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L25): to save the bigram score(weight)
* [Threechar](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L30): to save the trigram frequencies.
* [ThreecharVale](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L31):  to save the trigram score(weight)

now, I'm going to start with [Fitness constructor](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L45) which receives the Array of PlainTexts which we got it from Transipostion step and Array of keys(chromosomes), under this constructor, I initialized set of arrays to save the summation of bigram frequencies of each PlainText and  trigram frequencies summation, and another array to save the  final value of fitness for each PlainText, then I called methods to start calculating which follow:

* [FitnessMethod](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L61): this method cuts each PlainText to subsequent, one time to cut two-letter sequence with calling [checktwoChars](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L95) method to check if that sequence exists in the bigram frequencies array or not, and another time to cut three-letter sequence calling [checkthreeChars](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L112) method to check if that sequence exists in the trigram frequencies array or not so if it existed this method will add the score of that sequence to [Twocharcount](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L47) (two-letter sequence) /[Threecharcount](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L48) (three-letter sequence) which keeps the summation of the scores of each PlainText.

* [fitnessequation](): under this method, we will calculate the  final value of fitness for each PlainText by using the equation and save it in [Fitness](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L156) array.

* [Print](https://github.com/AbdullahTaher93/TFM/blob/a4eefef7c6f6d71e4b44ff380a6ed6dbc53719fc/src/cryptanalysis_gas/Fitness.java#L160): this method to print all of the plainTexts with their fitness values.

##### Experimental results

     No. of chromosomes is: 12
     length of chromosome is: 6
     CipherText: "epyrcntnoiXX"

   ![TransClass](https://github.com/AbdullahTaher93/TFM/blob/master/images/TransClass.png)

   ![Fitness](https://github.com/AbdullahTaher93/TFM/blob/master/images/Fitness.png)


### 4 Selection step

After getting fitness array for each PlainText from the previous step, it is time to select the best parents to generate a new population from those parents, let us firstly sort the fitness array descending  then select the best half of that array by using high fitness,in the [Selection.java](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/Selection.java) class, we have one selection contracture which receives  three parameters (the keys Array(chromosomes), PlainTexts Array, fitness Array ), under this contractor the first thing we have done it is initializing a set of arrays, 

* [selectkey](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/Selection.java#L25): to save the best of keys

* [selectPlinText](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/Selection.java#L26): to save the best plainText
 then we called two methods are the following:

* [Sell_sort](https://github.com/AbdullahTaher93/TFM/blob/a9aa771b749c22a744244eb962f17618d307e4e4/src/cryptanalysis_gas/Selection.java#L42): this method sorts the fitness array at the same time sorts the keys and plaintexts arrays depending on the fitness values.
note: the sell sort is one of the best sort ways are used to sort set of numbers

* [Selection](https://github.com/AbdullahTaher93/TFM/blob/a9aa771b749c22a744244eb962f17618d307e4e4/src/cryptanalysis_gas/Selection.java#L70): this method saves the best half of keys and plaintexts in other arrays and preppers them To produce a new generation

* [Print](https://github.com/AbdullahTaher93/TFM/blob/a9aa771b749c22a744244eb962f17618d307e4e4/src/cryptanalysis_gas/Selection.java#L84): to print the best keys and plaintexts.

##### Experimental results

     No. of chromosomes is: 12
     length of chromosome is: 6
     CipherText: "epyrcntnoiXX"

![Selection](https://github.com/AbdullahTaher93/TFM/blob/master/images/Selection1.png)

![Selection](https://github.com/AbdullahTaher93/TFM/blob/master/images/Selection2.png)

### CrossOver steps:

in this class, we  have to decide What better behavior to generate a new generation, for that, it's so important to step, as we explained in this [section](https://github.com/AbdullahTaher93/TFM#5--crossover-operation) that there are many CrossOver operators to generate a new population dependent on the previous generation, we have used the 3 operators, before starting to create methods to perform these operators we had created a new class, we called it [CrossOver](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/CrossOver.java) class which contents one [constructor] to initialize  set of arrays to save next generation and calls some methods that follow:

* [crossing]: this method receives the set of best parents whose  we got them from the Selection step, this method takes each parent individually and splits it into two equal parts then keeps the first part without change and do ascending sorts to the second then marriages them to represent a new child *an example * 

	Parent 1 = 5 4 6 3 1 2 so, the Child 1= 5 4 6 1 2 3
	Parent 2 = 1 6 5 4 3 2 so, the Child 2= 6 1 5 2 3 4 

* [onePoint](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/CrossOver.java#L151): this is another method to get a new population, but in this method, we will deal with two parents to generate Two children, as we explained in this [section](https://github.com/AbdullahTaher93/TFM#51-one-point-crossover), so, this method takes two parents and keeps the first part of the first parent splits them into two equal parts for generating a first-child, keeps the first part of the first parent without change and copy the remaining unused numbers from the second parent to the first child, then it does the same process to generate a second-child, but it will keep the first part of the second parent without change and copy the remaining unused numbers from the first parent to the second child *an example* 

	 Parent 1 = 5 4 6 |3 1 2 
   	 Parent 2 = 1 6 5 |4 3 2
	so, child 1= 5 4 6| 1 3 2 and child 2= 1 6 5 | 4 3 2

* [multiPoint](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/CrossOver.java#L176):this method is a generalization of the one-point crossover wherein alternating segments are swapped to get new off-springs * an example* 
            
               Parent 1 = 5 4 |6 3| 1 2 
               Parent 2 = 1 6 |5 4| 3 2
               so, child 1 = 1 5 |3 6 |4 2 , and child 2= 6 3| 5 4 |1 2 

* [marriage_keys](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/CrossOver.java#L137): The main purpose of creating this method is, as we know all of the CrossOver operators can generate N of children equals the number of parents Since the selection step gives us half of the original population Certainly the next generation will be half of the original population for that, this method receives two arrays the first array keeps all of the new children and the second array keeps  (the best parent whose got it from the selection step) or apply another crossover operator to give us the second half of child, 
finally, it will marriage the arrays and keep them into [newpopulionKey](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/CrossOver.java#L23) array which represents the next population.

* [Print](https://github.com/AbdullahTaher93/TFM/blob/master/src/cryptanalysis_gas/CrossOver.java#L234):this method will print the array of the new population.

##### Experimental results

     No. of chromosomes is: 12
     length of chromosome is: 6
     CrossOver Operator: crossing
     Keeps best parent to next Population: true

 ![crossing-prog](https://github.com/AbdullahTaher93/TFM/blob/master/images/crossing_prog.png)

 ![crossing-pop](https://github.com/AbdullahTaher93/TFM/blob/master/images/crossing_pop.png)


     No. of chromosomes is: 12
     length of chromosome is: 6
     CrossOver Operator: one point
     Keeps best parent to next Population: true

 ![one_point_prog](https://github.com/AbdullahTaher93/TFM/blob/master/images/one_point_prog.png)

 ![one_point-pop](https://github.com/AbdullahTaher93/TFM/blob/master/images/one_point_pop.png)


     No. of chromosomes is: 12
     length of chromosome is: 6
     CrossOver Operator: Multi point
     Keeps best parent to next Population: true

 ![multi_point_prog](https://github.com/AbdullahTaher93/TFM/blob/master/images/multi_point_prog.png)

 ![multi-point-pop](https://github.com/AbdullahTaher93/TFM/blob/master/images/multi_point_pop.png)

### Mutation Steps

 under this class [Mutation.java](https://github.com/AbdullahTaher93/TFM/blob/a9aa771b749c22a744244eb962f17618d307e4e4/src/cryptanalysis_gas/Mutation.java) we will mutate the gene, where We can determine a specific percentage of the generation then perform the mutation process on this part of the population only, so, the Mutation [constructor](https://github.com/AbdullahTaher93/TFM/blob/a9aa771b749c22a744244eb962f17618d307e4e4/src/cryptanalysis_gas/Mutation.java#L21) receives the array of the new gene which we got from CrossOver steps with a mutation  ratio in population, then we can mutate 2 positions for each child, these positions are random numbers in each child *an example*

 ![MutationEx](https://github.com/AbdullahTaher93/TFM/blob/master/images/MutationEx.png)

 Then we can call [Print](https://github.com/AbdullahTaher93/TFM/blob/a9aa771b749c22a744244eb962f17618d307e4e4/src/cryptanalysis_gas/Mutation.java#L54) method to print the array of population after mutation process. 


 Experimental results

          No. of chromosomes is: 12
          length of chromosome is: 6
          CrossOver Operator: crossing
          Keeps best parent to next Population: true
          Mutation Ratio: 100%

##### Table of population before applying Mutation process

![MutationRe](https://github.com/AbdullahTaher93/TFM/blob/master/images/MutationRes.png)

##### Table of population after applying Mutation process

![beforeMutation](https://github.com/AbdullahTaher93/TFM/blob/master/images/beforeMutation.png)

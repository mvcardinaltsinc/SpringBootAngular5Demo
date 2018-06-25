export interface Book {  
    id: number;
    bookTitle: String; 
    language: String; 
    actualCopies: number;
    currentCopies: number;
    category: 
        {
                id: number; 
                catgName: String
        }, 
    publicationYear: number;
}
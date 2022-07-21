export interface INote {
  noteId?:  number | any | undefined;
  title: string;
  description: string;
  color?: string;
  changesUpdate?: number;
  dateCreation?: string | Date | any;
  dateModification?: string | Date | any;
}

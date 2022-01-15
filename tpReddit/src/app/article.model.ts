export class Article {
  title: string;
  link: string;
  votes: number;
  id: number = 0;
  static ID: number = 0;
  constructor(title: string, link: string, votes?: number) {
    this.title = title;
    this.link = link;
    this.votes = votes || 0;
    this.id = Article.ID++;
  }

  voteUp(): void {
    this.votes += 1;
  }
  voteDown(): void {
    this.votes -= 1;
  }

  // domain(): string {
  //   try {
  //     // e.g. http://foo.com/path/to/bar
  //     const domainAndPath: string = this.link.split('//')[1];
  //     // e.g. foo.com/path/to/bar
  //     return domainAndPath.split('/')[0];
  //   } catch (err) {
  //     return 'Error';
  //   }
  // }
}

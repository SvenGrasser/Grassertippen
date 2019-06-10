import { TippspielClientPage } from './app.po';

describe('tippspiel-client App', function() {
  let page: TippspielClientPage;

  beforeEach(() => {
    page = new TippspielClientPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});

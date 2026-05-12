import { Test, TestingModule } from '@nestjs/testing';
import { EscaladorsController } from './escaladors.controller';

describe('EscaladorsController', () => {
  let controller: EscaladorsController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [EscaladorsController],
    }).compile();

    controller = module.get<EscaladorsController>(EscaladorsController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});

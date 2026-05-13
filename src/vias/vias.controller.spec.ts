import { Test, TestingModule } from '@nestjs/testing';
import { ViasController } from './vias.controller';

describe('ViasController', () => {
  let controller: ViasController;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      controllers: [ViasController],
    }).compile();

    controller = module.get<ViasController>(ViasController);
  });

  it('should be defined', () => {
    expect(controller).toBeDefined();
  });
});
